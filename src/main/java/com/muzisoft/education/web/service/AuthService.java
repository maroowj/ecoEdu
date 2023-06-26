package com.muzisoft.education.web.service;

import com.muzisoft.education.config.security.JwtProvider;
import com.muzisoft.education.domain.common.enums.Role;
import com.muzisoft.education.domain.file.EFileManager;
import com.muzisoft.education.domain.refreshtoken.RefreshToken;
import com.muzisoft.education.domain.refreshtoken.RefreshTokenRepository;
import com.muzisoft.education.domain.user.User;
import com.muzisoft.education.domain.user.UserRepository;
import com.muzisoft.education.utils.EntityUtils;
import com.muzisoft.education.utils.enums.SocialType;
import com.muzisoft.education.web.api.dto.common.TokenRequest;
import com.muzisoft.education.web.api.dto.common.TokenResponse;
import com.muzisoft.education.web.api.dto.user.LoginRequest;
import com.muzisoft.education.web.api.dto.user.SignupRequest;
import com.muzisoft.education.web.client.dto.SocialProfile;
import com.muzisoft.education.web.exception.business.CEntityNotFoundException.CUserNotFoundException;
import com.muzisoft.education.web.exception.business.CInvalidValueException;
import com.muzisoft.education.web.exception.business.CInvalidValueException.CAlreadySignedupException;
import com.muzisoft.education.web.exception.security.CTokenException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public User signup(SignupRequest req) {
        User user = User.create(req.getId(), req.getPassword(), req.getProvider());
        userRepository.findByUserId(user.getUserId()).ifPresent((foundUser) -> {
            throw new CAlreadySignedupException();
        });
        return userRepository.save(user);
    }

    @Transactional
    public void socialSignup(EFileManager profileImage, SocialProfile socialProfile, SocialType socialType) {
        User createdUser = signup(new SignupRequest(socialProfile.getEmail(), passwordEncoder.encode(UUID.randomUUID().toString()), socialType.name().toLowerCase()));
        createdUser.update(socialProfile.getUsername());
//        createdUser.getUserDetails().updateProfileImage(profileImage);
//        createdUser.getUserDetails().updateEmail(socialProfile.getEmail());
    }

    @Transactional
    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByUserId(request.getId()).orElseThrow(CInvalidValueException.CLoginFailedException::new);
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new CInvalidValueException.CLoginFailedException();
        }
        refreshTokenRepository.findByKey(user.getSeq()).ifPresent(refreshTokenRepository::delete);
        TokenResponse tokenResponse = jwtProvider.createToken(user.getSeq(), user.getRoles().stream().map(Role::getValue).collect(Collectors.toList()));
        refreshTokenRepository.save(RefreshToken.create(user.getSeq(), tokenResponse.getRefreshToken()));
        return tokenResponse;
    }

    @Transactional
    public TokenResponse socialLogin(LoginRequest request) {
        User user = userRepository.findByUserIdAndProvider(request.getId(), request.getProvider())
                .orElseThrow(CUserNotFoundException::new);
        refreshTokenRepository.findByKey(user.getSeq()).ifPresent(refreshTokenRepository::delete);
        TokenResponse tokenResponse = jwtProvider.createToken(user.getSeq(), user.getRoles().stream().map(Role::getValue).collect(Collectors.toList()));
        refreshTokenRepository.save(RefreshToken.create(user.getSeq(), tokenResponse.getRefreshToken()));
        return tokenResponse;
    }

    /**
     * TokenRequest를 통해 액세스 토큰 재발급 요청
     * * 리프레시 토큰 만료 검증 -> 만료 시 재로그인 요청
     */
    @Transactional
    public TokenResponse reissue(TokenRequest request) {

        //리프레시 토큰 만료
        if(!jwtProvider.validationToken(request.getRefreshToken())) {
            throw new CTokenException.CRefreshTokenException();
        }

        String accessToken = request.getAccessToken();
        Authentication authentication = jwtProvider.getAuthentication(accessToken);
        User foundUser = EntityUtils.userThrowable(userRepository, ((User)authentication.getPrincipal()).getSeq());

        //리프레시 토큰 없음
        RefreshToken refreshToken = refreshTokenRepository.findByKey(foundUser.getSeq())
                .orElseThrow(CTokenException.CRefreshTokenException::new);

        //리프레시 토큰 불일치
        if(!refreshToken.getToken().equals(request.getRefreshToken())) {
            throw new CTokenException.CRefreshTokenException();
        }

        TokenResponse newCreatedToken = jwtProvider.createToken(foundUser.getSeq(), foundUser.getRoles().stream().map(Role::getValue).collect(Collectors.toList()));
        refreshToken.update(newCreatedToken.getRefreshToken());

        return newCreatedToken;
    }
}

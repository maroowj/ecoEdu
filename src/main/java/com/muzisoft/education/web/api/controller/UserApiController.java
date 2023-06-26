package com.muzisoft.education.web.api.controller;

import com.muzisoft.education.utils.enums.SocialType;
import com.muzisoft.education.utils.handler.FileHandler;
import com.muzisoft.education.web.api.dto.common.TokenRequest;
import com.muzisoft.education.web.api.dto.common.TokenResponse;
import com.muzisoft.education.web.api.dto.user.LoginRequest;
import com.muzisoft.education.web.api.dto.user.SignupRequest;
import com.muzisoft.education.web.api.dto.user.SocialLoginRequest;
import com.muzisoft.education.web.api.dto.user.SocialSignupRequest;
import com.muzisoft.education.web.client.dto.SocialProfile;
import com.muzisoft.education.web.exception.business.CEntityNotFoundException.CUserNotFoundException;
import com.muzisoft.education.web.exception.social.CSocialException.CSocialAgreementException;
import com.muzisoft.education.web.service.AuthService;
import com.muzisoft.education.web.service.social.OAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApiController {

    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;
    private final FileHandler fileHandler;
    private final OAuthService oauthService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Validated SignupRequest signupRequest) {
        signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        authService.signup(signupRequest);
    }

    @PostMapping("/social/{socialType}")
    @ResponseStatus(HttpStatus.CREATED)
    public void socialSignup(@PathVariable(name = "socialType") SocialType socialType,
                             @RequestBody @Validated SocialSignupRequest request) {

        //구글은 access_token 대신 id_token 값으로 요청
        SocialProfile socialProfile = oauthService.profile(socialType, request.getAccessToken());

        //소셜 프로필이 없는 경우 에러
        if (ObjectUtils.isEmpty(socialProfile)) throw new CUserNotFoundException();

        //동의 항목(이메일)에 동의하지 않은 경우 연결 끊은 후 에러
        if (!StringUtils.hasText(socialProfile.getEmail())) {
            oauthService.unlink(socialType, request.getAccessToken());
            throw new CSocialAgreementException();
        }

        //이미지가 있으면 FileManager 로 변환
//        authService.socialSignup(new SignupRequest(socialProfile.getEmail(), null, socialProfile.getUsername(), socialProfile.getProfileImageUrl(), socialType.name().toLowerCase()));
        authService.socialSignup(fileHandler.parseImageUrl(socialProfile.getProfileImageUrl(), "user-img"), socialProfile, socialType);
    }

    @PostMapping("/token")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse login(@RequestBody @Validated LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/social/{socialType}/token")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse socialLogin(@PathVariable(name = "socialType") SocialType socialType,
                                     @RequestBody @Validated SocialLoginRequest request) {

        SocialProfile socialProfile = oauthService.profile(socialType, request.getAccessToken());

        //소셜 프로필이 없는 경우 에러
        if(ObjectUtils.isEmpty(socialProfile)) throw new CUserNotFoundException();

        return authService.socialLogin(new LoginRequest(socialProfile.getEmail(), null, socialType.name().toLowerCase()));
    }

    @PostMapping("/token/expiration")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse reissue(@RequestBody @Validated TokenRequest request) {
        return authService.reissue(request);
    }

}

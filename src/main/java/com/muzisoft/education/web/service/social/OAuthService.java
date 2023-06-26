package com.muzisoft.education.web.service.social;

import com.muzisoft.education.utils.enums.SocialType;
import com.muzisoft.education.web.client.OAuthClient;
import com.muzisoft.education.web.client.dto.OAuthTokenResponse;
import com.muzisoft.education.web.client.dto.SocialProfile;
import com.muzisoft.education.web.exception.social.CSocialException.CInvalidSocialTypeException;
import com.muzisoft.education.web.exception.social.CSocialException.CSocialCommunicationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OAuthService {

    private final List<OAuthClient> socialOAuthList;
    private final HttpServletResponse response;

    public void request(SocialType socialType) {
        OAuthClient socialOauth = this.findSocialOauthByType(socialType);
        String redirectURL = socialOauth.getOauthRedirectURL();
        try {
            response.sendRedirect(redirectURL);
        } catch (IOException e) {
            log.error(e.toString());
            throw new CSocialCommunicationException();
        }
    }

    public OAuthTokenResponse tokenInfo(SocialType socialType, String code) {
        OAuthClient socialOauth = this.findSocialOauthByType(socialType);
        return socialOauth.getTokenInfo(code);
    }

    public SocialProfile profile(SocialType socialType, String accessToken) {
        OAuthClient socialOauth = this.findSocialOauthByType(socialType);
        return socialOauth.getProfile(accessToken);
    }

    public void unlink(SocialType socialType, String accessToken) {
        OAuthClient socialOauth = this.findSocialOauthByType(socialType);
        socialOauth.unlink(accessToken);
    }

    private OAuthClient findSocialOauthByType(SocialType socialType) {
        return socialOAuthList.stream()
                .filter(x -> x.type() == socialType)
                .findFirst()
                .orElseThrow(CInvalidSocialTypeException::new);
    }
}

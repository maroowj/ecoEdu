package com.muzisoft.education.web.client;

import com.muzisoft.education.EducationApplication;
import com.muzisoft.education.web.client.dto.NaverProfile;
import com.muzisoft.education.web.client.dto.OAuthTokenResponse;
import com.muzisoft.education.web.client.dto.SocialProfile;
import com.muzisoft.education.web.exception.social.CSocialException.CSocialCommunicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class NaverOAuthClient implements OAuthClient {

    private final WebClient webClient;
    private final EducationApplication application;

    @Value("${social.naver.client-id}")
    private String naverClientId;

    @Value("${social.naver.client-secret}")
    private String naverClientSecret;

    @Value("${social.naver.redirect}")
    private String naverRedirectUri;

    @Value("${social.naver.url.login}")
    private String naverLoginUrl;

    @Value("${social.naver.url.token}")
    private String naverTokenUrl;

    @Value("${social.naver.url.profile}")
    private String naverProfileUrl;

    @Value("${social.naver.url.unlink}")
    private String naverUnlinkUrl;

    @Override
    public String getOauthRedirectURL() {
        Map<String, Object> params = new HashMap<>();

        params.put("response_type", "code");
        params.put("client_id", naverClientId);
        params.put("redirect_uri", application.hostAddress() + naverRedirectUri);
        params.put("state", UUID.randomUUID().toString());

        String parameterString = params.entrySet().stream()
                .map(x -> x.getKey() + "=" + x.getValue())
                .collect(Collectors.joining("&"));

        return naverLoginUrl + "?" + parameterString;
    }

    @Override
    public OAuthTokenResponse getTokenInfo(String code) {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", naverClientId);
        params.add("client_secret", naverClientSecret);
        params.add("code", code);
        params.add("state", UUID.randomUUID().toString());

        return webClient.post()
                .uri(naverTokenUrl, builder -> builder.queryParams(params).build())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new CSocialCommunicationException()))
                .onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new CSocialCommunicationException()))
                .bodyToMono(OAuthTokenResponse.class)
                .block();
    }

    @Override
    public SocialProfile getProfile(String accessToken) {
        NaverProfile naverProfile = webClient.post()
                .uri(naverProfileUrl)
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new CSocialCommunicationException()))
                .onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new CSocialCommunicationException()))
                .bodyToMono(NaverProfile.class)
                .block();

        return new SocialProfile(naverProfile.getResponse().getEmail(), naverProfile.getResponse().getNickname(), naverProfile.getResponse().getProfile_image());
    }

    @Override
    public void unlink(String accessToken) {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "delete");
        params.add("client_id", naverClientId);
        params.add("client_secret", naverClientSecret);
        params.add("access_token", accessToken);

        webClient.post()
                .uri(naverTokenUrl, builder -> builder.queryParams(params).build())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new CSocialCommunicationException()))
                .onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new CSocialCommunicationException()));
    }
}

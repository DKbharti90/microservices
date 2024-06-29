package com.dk.user.service.UserService.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import java.util.Objects;

public class FeignClientInterceptor implements RequestInterceptor {

    private OAuth2AuthorizedClientManager auth2AuthorizedClientManager;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token= Objects.requireNonNull(auth2AuthorizedClientManager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build())).getAccessToken().getTokenValue();
        requestTemplate.header("Authorization", "Bearer "+token);
    }
}

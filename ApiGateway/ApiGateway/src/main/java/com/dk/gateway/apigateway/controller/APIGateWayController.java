package com.dk.gateway.apigateway.controller;

import com.dk.gateway.apigateway.model.AuthResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class APIGateWayController {

    private Logger logger= LoggerFactory.getLogger(APIGateWayController.class);




    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user,
            Model model
            ){
            logger.info("User Email : {} ", user.getEmail());

            AuthResponse authResponse=new AuthResponse();
            authResponse.setUserId(user.getEmail());
            authResponse.setAccessToken(client.getAccessToken().getTokenValue());
            authResponse.setRefreshToken(Objects.requireNonNull(client.getRefreshToken()).getTokenValue());
            authResponse.setExpireAt(Objects.requireNonNull(client.getAccessToken().getExpiresAt()).toEpochMilli());

            List<String> authorities= user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
            authResponse.setAuthorities(authorities);

            return new ResponseEntity<>(authResponse, HttpStatus.OK);

    }



}

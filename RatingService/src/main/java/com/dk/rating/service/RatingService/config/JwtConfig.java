package com.dk.rating.service.RatingService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@Configuration
public class JwtConfig {


    @Bean
    public JwtDecoder jwtDecoder(){
        String issuerUri = "https://example.com/oauth2/default";
        return NimbusJwtDecoder.withIssuerLocation(issuerUri).build();
    }
}

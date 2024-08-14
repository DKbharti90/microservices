package com.dk.rating.service.RatingService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{


    private final JwtDecoder jwtDecoder;

    public WebSecurityConfig(JwtDecoder jwtDecoder) {
        this.jwtDecoder = jwtDecoder;
    }


    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

       /* httpSecurity
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer(oauth2 -> oauth2
                                .jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder))
                        //.jwt(jwt -> jwt.decoder(jwtDecoder).jwtAuthenticationConverter(jwtAuthenticationConverter()))

                );*/

        httpSecurity.authorizeHttpRequests(authorize->authorize.anyRequest().authenticated()).oauth2ResourceServer(oauth->oauth.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder)));

        return httpSecurity.build();

    }


    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        // Add custom authorities converter if needed
        return converter;
    }
}



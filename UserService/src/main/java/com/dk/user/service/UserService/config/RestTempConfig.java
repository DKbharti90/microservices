package com.dk.user.service.UserService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

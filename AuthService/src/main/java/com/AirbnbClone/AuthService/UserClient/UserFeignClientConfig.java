package com.AirbnbClone.AuthService.UserClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.RequestInterceptor;

@Configuration
public class UserFeignClientConfig {     
    
    @Value("${api.key.header}")
    private String API_KEY_HEADER;
    @Value("${api.key.secret}")
    private String API_SECRET_KEY;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(API_KEY_HEADER, API_SECRET_KEY);
        };
    }
}

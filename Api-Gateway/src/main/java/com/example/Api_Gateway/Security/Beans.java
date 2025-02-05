package com.example.Api_Gateway.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Beans {
    
    
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
}

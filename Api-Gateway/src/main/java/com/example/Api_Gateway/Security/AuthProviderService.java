package com.example.Api_Gateway.Security;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthProviderService {

    private final RestTemplate restTemplate;

    public void ValidateToken(String token){
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        httpHeaders.add(HttpHeaders.AUTHORIZATION, token);
        ResponseEntity<String> response =  restTemplate.exchange("http://service-b/api/endpoint",
        HttpMethod.GET,
        entity,
        String.class
        );
        System.out.println(response);
    }
    
}

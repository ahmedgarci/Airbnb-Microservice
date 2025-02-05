package com.example.Api_Gateway.Security;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthProviderService {

    private final RestTemplate restTemplate;

    public void validateToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8093/auth/validate",
                HttpMethod.GET,
                entity,
                String.class
            );
            System.out.println("Token validated successfully: " + response.getBody());
        } catch (HttpClientErrorException e) {
            System.err.println("Invalid token: " + e.getStatusCode());
            throw e; 
        }
    }
}

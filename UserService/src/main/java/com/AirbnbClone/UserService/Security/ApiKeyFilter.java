package com.AirbnbClone.UserService.Security;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

    private  final String API_KEY_HEADER = "X-API-KEY";
    private final  String Api_Secret_Key= "P9T2Q-Y97VY3hjm_m3mj9tJ1DEjTw6YdbtQJ3zOd_yk";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                final String apiKeyFromRequest = request.getHeader(API_KEY_HEADER);
                if(apiKeyFromRequest == null || !apiKeyFromRequest.equals(Api_Secret_Key)){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
                filterChain.doFilter(request, response);

            }

   
    
}

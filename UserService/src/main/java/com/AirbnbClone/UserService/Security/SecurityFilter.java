package com.AirbnbClone.UserService.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityFilter {

    private final ApiKeyFilter apiKeyFilter;

    @Bean
    public SecurityFilterChain filter(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.cors()
            .and()
            .csrf().disable()
            .authorizeRequests()
            .requestMatchers("/user/create").permitAll()
            .and()
            .addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter.class);

            return httpSecurity.build();

    }

}
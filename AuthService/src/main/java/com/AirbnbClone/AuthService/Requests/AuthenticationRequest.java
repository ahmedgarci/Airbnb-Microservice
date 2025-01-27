package com.AirbnbClone.AuthService.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AuthenticationRequest {
    
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
}

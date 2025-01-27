package com.AirbnbClone.AuthService.Requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RegisterRequest {

    @NotBlank
    @Email(message = "email is not well formatted ")
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
    @NotBlank
    private String userName;
    
}

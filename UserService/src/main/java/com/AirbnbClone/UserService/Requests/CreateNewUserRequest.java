package com.AirbnbClone.UserService.Requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateNewUserRequest {
    @NotBlank()
    @Email()
    private String email;
    @NotBlank
    @Size(min = 8 , message = "password length must be at least 8 chars ")
    private String password;

}

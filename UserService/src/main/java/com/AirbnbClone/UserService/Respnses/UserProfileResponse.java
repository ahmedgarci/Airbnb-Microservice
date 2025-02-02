package com.AirbnbClone.UserService.Respnses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserProfileResponse {
    
    private String lastName;
    private String email;
    private Number phoneNumber;
    private String password;
}

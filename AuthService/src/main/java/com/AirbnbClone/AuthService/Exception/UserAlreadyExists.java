package com.AirbnbClone.AuthService.Exception;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(String msg){
        super(msg);
    }
}

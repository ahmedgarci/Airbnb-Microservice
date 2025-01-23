package com.AirbnbClone.PropertyService.Exceptions;

public class UnauthorizedAccessException extends RuntimeException {

    public UnauthorizedAccessException(String msg){
        super(msg);
    }
    
}

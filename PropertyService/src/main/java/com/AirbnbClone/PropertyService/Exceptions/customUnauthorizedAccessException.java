package com.AirbnbClone.PropertyService.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class customUnauthorizedAccessException extends RuntimeException {

    public customUnauthorizedAccessException(String msg){
        super(msg);
    }
    
}

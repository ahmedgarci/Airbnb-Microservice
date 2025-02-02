package com.AirbnbClone.AuthService.Handler;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.AirbnbClone.AuthService.Exception.UserAlreadyExists;
import com.AirbnbClone.AuthService.Responses.customErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<customErrorResponse> customUserAlreadyExistsException(UserAlreadyExists exception){
        customErrorResponse errorResponse = new customErrorResponse(exception.getMessage(),HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String,String>> handleValidationException(MethodArgumentNotValidException exception){
        HashMap<String,String> errors = new HashMap<>();
        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        } 
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);        
    }

    
    

    

}

package com.AirbnbClone.PropertyService.Handler;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import com.AirbnbClone.PropertyService.Responses.ErrorResponse;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.AirbnbClone.PropertyService.Exceptions.customEntityNotFoundException;
import com.AirbnbClone.PropertyService.Exceptions.customUnauthorizedAccessException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(customEntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(customEntityNotFoundException exception){
        Integer notFoundStatus = HttpStatus.NOT_FOUND.value();
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(),notFoundStatus);
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    
    
    @ExceptionHandler(customUnauthorizedAccessException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(customUnauthorizedAccessException exception){
        Integer notFoundStatus = HttpStatus.UNAUTHORIZED.value();
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(),notFoundStatus);
        return new ResponseEntity<>(errorResponse,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String,String>> handleValidationError(MethodArgumentNotValidException exception){
        HashMap<String,String> validationErrors = new HashMap<>();
        for(FieldError error: exception.getBindingResult().getFieldErrors()){
            validationErrors.put(error.getField(),error.getDefaultMessage());
        }
        return new ResponseEntity<>(validationErrors,HttpStatus.BAD_REQUEST);

    }


}

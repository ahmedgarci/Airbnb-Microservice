package com.AirbnbClone.PropertyService.Responses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class ErrorResponse {
        private String message;
        private int status;    
}

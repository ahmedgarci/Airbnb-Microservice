package com.AirbnbClone.PropertyService.Requests;

import com.AirbnbClone.PropertyService.Property.PropertyState;


import lombok.Getter;

@Getter
public class CreatePropertyRequest {
    
    
    private String title;
    
    private String description;
    
    private String address;
    
    private String city;
    
    private String country;
    
    private Integer maxGuests;
    
    private Integer pricePerNight;



}

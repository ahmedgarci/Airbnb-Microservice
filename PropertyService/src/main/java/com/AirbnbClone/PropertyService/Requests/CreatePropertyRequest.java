package com.AirbnbClone.PropertyService.Requests;

import java.util.Set;

import com.AirbnbClone.PropertyService.Facility.Facility;
import com.AirbnbClone.PropertyService.Property.PropertyState;
import com.AirbnbClone.PropertyService.Property.PropertyType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreatePropertyRequest {
    
    @NotBlank(message = "title should contain a value")
    private String title;
    @NotBlank(message = "description should contain a value")
    private String description;
    @NotBlank(message = "addressn!  should contain a value")
    private String address;
    @NotBlank(message = "city should contain a value")
    private String city;
    @NotBlank(message = "country should contain a value")
    private String country;
    @NotNull(message = "max guests can t be null")
    private Integer maxGuests;
    @NotNull(message = "price per night can t be null")
    private Integer pricePerNight;
    @NotEmpty()
    private Set<String> facilities;
    
    private PropertyType propertyType;

    
}

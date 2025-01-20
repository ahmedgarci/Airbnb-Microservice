package com.AirbnbClone.PropertyService.Property;

import org.springframework.stereotype.Service;

import com.AirbnbClone.PropertyService.Requests.CreatePropertyRequest;
import com.AirbnbClone.PropertyService.Responses.PropertyResponse;

import jakarta.validation.constraints.NotNull;

@Service
public class PropertyMapper {

    public Property toProperty(@NotNull CreatePropertyRequest request){
        return  Property.builder().description(request.getDescription())
        .address(request.getAddress()).city(request.getCity()).country(request.getCountry())
        .pricePerNight(request.getPricePerNight())
        .title(request.getTitle()).maxGuests(request.getMaxGuests()).build();
    }
    
    public PropertyResponse toPropertyResponse(Property property){
        return new PropertyResponse(property.getId(),property.getTitle(),
        property.getDescription(),property.getAddress(),property.getCity(),property.getCountry(),property.getMaxGuests(),
        property.getPricePerNight(),property.getPropertyState().toString()
        );
    }
}
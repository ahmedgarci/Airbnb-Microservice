package com.AirbnbClone.PropertyService.Property;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.AirbnbClone.PropertyService.Facility.Facility;
import com.AirbnbClone.PropertyService.Requests.CreatePropertyRequest;
import com.AirbnbClone.PropertyService.Responses.PropertyCardResponse;
import com.AirbnbClone.PropertyService.Responses.PropertyResponse;

import jakarta.validation.constraints.NotNull;

@Service
public class PropertyMapper {

    public Property toProperty(@NotNull CreatePropertyRequest request){
        return  Property.builder().description(request.getDescription())
        .address(request.getAddress()).city(request.getCity()).country(request.getCountry()).type(request.getPropertyType())
        .pricePerNight(request.getPricePerNight()).propertyState(PropertyState.AVAILABLE)
        .title(request.getTitle()).maxGuests(request.getMaxGuests()).comments(List.of()).build();
    }
    
    public PropertyResponse toPropertyResponse(Property property){
        return PropertyResponse.builder().id(property.getId()).title(property.getTitle()).description(
        property.getDescription()).address(property.getAddress()).city(property.getCity()).country(property.getCountry()).maxGuests(property.getMaxGuests())
        .pricePerNight(property.getPricePerNight()).propertyState(property.getPropertyState().toString()).facilities(
        property.getFacilities() != null  ? property.getFacilities().stream().map((element)->element.getName()).collect(Collectors.toSet()): Set.of())
        .comments(property.getComments() != null ? property.getComments() : List.of()).propertyType( property.getType() != null ? property.getType().toString() : null )
        .build();

    }
}
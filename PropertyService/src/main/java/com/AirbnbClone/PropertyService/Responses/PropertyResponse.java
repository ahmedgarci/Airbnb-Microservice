package com.AirbnbClone.PropertyService.Responses;

import java.util.List;
import java.util.Set;


import com.AirbnbClone.PropertyService.Comment.PropertyComment;
import com.AirbnbClone.PropertyService.Facility.Facility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyResponse {
    private Integer id;
    private String title;
    private String description;
    private String address;
    private String city;
    private String country;
    private Integer maxGuests;
    private Integer pricePerNight;
    private String propertyState;
 //   private List<> photoUrls; 
    private Set<String> facilities;
    private List<PropertyComment> comments;

    private String propertyType;
    







}

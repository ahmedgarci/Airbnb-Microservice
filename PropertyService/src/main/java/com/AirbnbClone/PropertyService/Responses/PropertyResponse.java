package com.AirbnbClone.PropertyService.Responses;

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
//    private List<String> photoUrls; 
//    private Set<Facility> facilities;
}

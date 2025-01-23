package com.AirbnbClone.PropertyService.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PropertyCardResponse {
    private Integer id;
    private String city;
    private String country;
    private Integer pricePerNight;


}

package com.AirbnbClone.PropertyService.Facility;

import org.springframework.stereotype.Service;

@Service
public class FacilityMapper {
    public String FacilityToString(Facility facility){
        return facility.getName();
    }    
}

package com.AirbnbClone.PropertyService.Services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.AirbnbClone.PropertyService.Exceptions.EntityAlreadyExists;
import com.AirbnbClone.PropertyService.Facility.Facility;
import com.AirbnbClone.PropertyService.Facility.FacilityRepository;
import com.AirbnbClone.PropertyService.Property.Property;
import com.AirbnbClone.PropertyService.Property.PropertyRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FacilityService {

    private final FacilityRepository facilityRepository;

    public Set<String> getAllFacilities(){
        return facilityRepository.getAllFacilityNames();
    }


}

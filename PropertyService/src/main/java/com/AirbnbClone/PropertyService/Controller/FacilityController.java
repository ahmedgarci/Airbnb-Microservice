package com.AirbnbClone.PropertyService.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AirbnbClone.PropertyService.Exceptions.EntityAlreadyExists;
import com.AirbnbClone.PropertyService.Facility.Facility;
import com.AirbnbClone.PropertyService.Services.FacilityService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;



@RequiredArgsConstructor
@Controller
@RequestMapping("/facilities/")
public class FacilityController {

    private final FacilityService facilityService;
    
    @GetMapping("all")
    public ResponseEntity<Set<String>> getAllFacilities() {
        return ResponseEntity.ok(facilityService.getAllFacilities());
    }
    
    

    

}

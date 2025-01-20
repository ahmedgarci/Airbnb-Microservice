package com.AirbnbClone.PropertyService.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AirbnbClone.PropertyService.Requests.CreatePropertyRequest;
import com.AirbnbClone.PropertyService.Responses.PageResponse;
import com.AirbnbClone.PropertyService.Responses.PropertyResponse;
import com.AirbnbClone.PropertyService.Services.PropertyService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
@RequestMapping("/property/")
public class PropertyController {
    private final PropertyService propertyService;

    @PostMapping("create")
    public ResponseEntity<Integer> CreateNewProperty(@RequestBody CreatePropertyRequest request) {
    return ResponseEntity.ok(propertyService.createNewProperty(request));        
    }

    @GetMapping("all")
    public ResponseEntity<PageResponse<PropertyResponse>> getProperties(
        @RequestParam(name = "page" , defaultValue = "0" , required = false) Integer page,
        @RequestParam(name = "size",defaultValue = "10" , required = false) Integer size 
        ) {
            return ResponseEntity.ok(propertyService.findAllProperties(page, size));
       }
    


    
    
}

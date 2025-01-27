package com.AirbnbClone.PropertyService.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AirbnbClone.PropertyService.Requests.CreatePropertyRequest;
import com.AirbnbClone.PropertyService.Responses.PageResponse;
import com.AirbnbClone.PropertyService.Responses.PropertyCardResponse;
import com.AirbnbClone.PropertyService.Responses.PropertyResponse;
import com.AirbnbClone.PropertyService.Services.PropertyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;



@RequiredArgsConstructor
@Controller
@RequestMapping("/property/")
@CrossOrigin(value = "http://localhost:3000")
public class PropertyController {
    private final PropertyService propertyService;

    @PostMapping("create")
    public ResponseEntity<Integer> CreateNewProperty(@RequestBody @Valid CreatePropertyRequest request) {
    return ResponseEntity.ok(propertyService.createNewProperty(request));        
    }

    @GetMapping("all")
    public ResponseEntity<PageResponse<PropertyCardResponse>> getProperties(
        @RequestParam(name = "page" , defaultValue = "0" , required = false) Integer page,
        @RequestParam(name = "size",defaultValue = "10" , required = false) Integer size 
        ){
            return ResponseEntity.ok(propertyService.findAllProperties(page, size));
        }
    
    @DeleteMapping("delete/{propertyId}/{userId}")
    public void deleteUserProperty(@PathVariable Integer propertyId,@PathVariable Integer userId) {
            propertyService.deletePropertyByHostId(propertyId,userId); 
    }       

    @GetMapping("{propertyId}")
    public ResponseEntity<PropertyResponse> getPropertyById(@PathVariable Integer propertyId) {
        return ResponseEntity.ok(propertyService.getPropertyById(propertyId));
    }
    
    @GetMapping("exists/{propertyId}")    
    public ResponseEntity<Boolean> checkIfPropertyExists(@PathVariable Integer propertyId){
        return ResponseEntity.ok(propertyService.checkIfPropertyExists(propertyId));
    }


    
}

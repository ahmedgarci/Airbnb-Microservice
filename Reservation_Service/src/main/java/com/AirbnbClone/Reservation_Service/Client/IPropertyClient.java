package com.AirbnbClone.Reservation_Service.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(
    name = "PropertyService",
    url="http://localhost:8090/property/"
)
public interface IPropertyClient {
    
    @GetMapping("exits/{propertyId}")
    Boolean findPropertyById(@PathVariable Integer propertyId);

//    @PatchMapping("updateState/{propertyId}");
    



}

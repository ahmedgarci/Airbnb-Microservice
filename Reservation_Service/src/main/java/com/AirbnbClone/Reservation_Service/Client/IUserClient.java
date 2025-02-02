package com.AirbnbClone.Reservation_Service.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(
    name = "AuthService",
    url = "http://localhost:8093"   
)
public interface IUserClient {
    
    @GetMapping()
    Boolean aa(@PathVariable Integer id);
    
}

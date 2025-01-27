package com.AirbnbClone.Reservation_Service.Client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.AirbnbClone.Reservation_Service.Responses.UserReponse;

@FeignClient(
    name = "",
    url = ""   
)
public interface IUserClient {
    
    @GetMapping("")
    Optional<UserReponse> findUserById(@PathVariable Integer id);    
    
}

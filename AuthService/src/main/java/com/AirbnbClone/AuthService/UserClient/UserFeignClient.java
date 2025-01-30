package com.AirbnbClone.AuthService.UserClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.AirbnbClone.AuthService.Requests.RegisterRequest;


@FeignClient(
    name = "UserService",
    url = "http://localhost:8095",
    configuration = UserFeignClientConfig.class
)
public interface UserFeignClient {
    
    @PostMapping("/user/create")
    void SaveUser(@RequestBody RegisterRequest request);
    
}

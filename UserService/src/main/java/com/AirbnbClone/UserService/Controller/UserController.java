package com.AirbnbClone.UserService.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.AirbnbClone.UserService.Requests.CreateNewUserRequest;
import com.AirbnbClone.UserService.Requests.UpdateUserDetailsRequest;
import com.AirbnbClone.UserService.Services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/user/")
@RequiredArgsConstructor
public class UserController{

    private final UserService userService;
    
    @PostMapping("create")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateNewUserRequest request) {
        userService.SaveUserNewUser(request);
        return ResponseEntity.ok("user created ");
    }

    @PostMapping(value = "details", consumes = "multipart/form-data")
    public ResponseEntity<?> FinaliseUserProfileCreation( MultipartFile file,@Valid @RequestBody UpdateUserDetailsRequest request) {
        return ResponseEntity.ok("user created ");
    }
    


}

package com.AirbnbClone.UserService.User;

import org.springframework.stereotype.Component;

import com.AirbnbClone.UserService.Requests.CreateNewUserRequest;

@Component
public class UserMapper {


    public User toUser (CreateNewUserRequest request){
        return User.builder().email(request.getEmail()).password(request.getPassword()).build();
    }


}

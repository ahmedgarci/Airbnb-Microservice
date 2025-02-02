package com.AirbnbClone.UserService.Services;

import org.springframework.stereotype.Service;

import com.AirbnbClone.UserService.Requests.CreateNewUserRequest;
import com.AirbnbClone.UserService.Requests.UpdateUserDetailsRequest;
import com.AirbnbClone.UserService.Respnses.UserProfileResponse;
import com.AirbnbClone.UserService.User.UserMapper;
import com.AirbnbClone.UserService.User.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public void SaveUserNewUser(CreateNewUserRequest request){
        userRepository.save(userMapper.toUser(request));        
    }

    public Integer UpdateUserDetails(UpdateUserDetailsRequest request){
        
    }

    public UserProfileResponse getUserDetails(){
        return null;
    }




}

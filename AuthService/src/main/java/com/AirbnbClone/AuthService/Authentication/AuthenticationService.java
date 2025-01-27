package com.AirbnbClone.AuthService.Authentication;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.AirbnbClone.AuthService.Entities.userEntity;
import com.AirbnbClone.AuthService.Entities.userRepository;
import com.AirbnbClone.AuthService.Exception.UserAlreadyExists;
import com.AirbnbClone.AuthService.Requests.AuthenticationRequest;
import com.AirbnbClone.AuthService.Requests.RegisterRequest;
import com.AirbnbClone.AuthService.Responses.AuthenticationResponse;
import com.AirbnbClone.AuthService.Security.JwtUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    
    private final userRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtService;



    public void RegisterUser(RegisterRequest request){
        Optional<userEntity> user = userRepo.findByEmail(request.getEmail());
        if(user.isPresent()){
            throw new UserAlreadyExists("user already exists");
        }
        userEntity newUser = userEntity.builder().email(request.getEmail()).password(
            passwordEncoder.encode(request.getPassword())).build();
        userRepo.save(newUser);
        // TO SAVE THE USER IN USER M
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        userEntity user = ((userEntity) auth.getPrincipal());
        return AuthenticationResponse.builder().Token(jwtService.generateJwtToken(user.getId(), user.getEmail())).build();
        
    }




}

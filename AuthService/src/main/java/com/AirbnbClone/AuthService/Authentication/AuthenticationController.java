package com.AirbnbClone.AuthService.Authentication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AirbnbClone.AuthService.Requests.AuthenticationRequest;
import com.AirbnbClone.AuthService.Requests.RegisterRequest;
import com.AirbnbClone.AuthService.Responses.AuthenticationResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
public class AuthenticationController {
    
    private final AuthenticationService authenticationService;

    @PostMapping("register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        authenticationService.RegisterUser(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
    

    

}

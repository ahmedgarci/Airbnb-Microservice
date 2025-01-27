package com.AirbnbClone.AuthService.Entities;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository  extends JpaRepository<userEntity,Integer> {

    Optional<userEntity> findByEmail(String email);
 
    

}

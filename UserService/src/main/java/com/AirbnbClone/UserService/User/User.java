package com.AirbnbClone.UserService.User;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable= true, updatable = true)
    private String firstName;
    @Column(nullable= true, updatable = true)
    private String lastName;
    @NotBlank()
    @Column(nullable = false, unique = true , updatable = false)
    private String email;
    @Column(nullable= true, updatable = true)
    private Number phoneNumber;
    @NotBlank()
    @Column(nullable = false , updatable = false)
    private String password;
    @Column(nullable= true, updatable = true)
    private String profilePictureUrl;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    
}

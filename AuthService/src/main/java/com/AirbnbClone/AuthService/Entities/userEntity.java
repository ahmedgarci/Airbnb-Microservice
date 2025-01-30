package com.AirbnbClone.AuthService.Entities;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class userEntity implements UserDetails , Principal {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Integer id;

        @NotBlank
        @Column(updatable = false, nullable = false,unique = true)        
        private String email;

        @NotBlank
        @Column(updatable = false, nullable = false)
        private String password;

        @Builder.Default
        private String role="ROLE_USER";

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new SimpleGrantedAuthority(role));
        }

        @Override
        public String getUsername() {
                return email;
        }

        @Override
        public String getName() {
                return email;
        }

}

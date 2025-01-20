package com.AirbnbClone.PropertyService.Property;

import java.util.List;
import java.util.Set;

import com.AirbnbClone.PropertyService.Comment.PropertyComment;
import com.AirbnbClone.PropertyService.Facility.Facility;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Property {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer  id;
    
    private Integer hostId;
    
    private String title;
    
    private String description;
    
    private String address;
    
    private String city;
    
    private String country;
    
    private Integer maxGuests;
    
    private Integer pricePerNight;

    private PropertyState propertyState;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true) 
    private Set<Facility> facilities;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PropertyComment> comments;
}

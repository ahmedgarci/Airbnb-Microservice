package com.AirbnbClone.PropertyService.Property;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.AirbnbClone.PropertyService.Comment.PropertyComment;
import com.AirbnbClone.PropertyService.Facility.Facility;
import com.AirbnbClone.PropertyService.Photo.PropertyPhoto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Property {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer  id;
    
    private Integer hostId;
    
    private String title;
    
    private String description;
    
    @Enumerated(EnumType.STRING)
    private PropertyType type;

    private String address;
    
    private String city;
    
    private String country;
    
    private Integer maxGuests;
    
    private Integer pricePerNight;

    @Enumerated(EnumType.STRING)
    private PropertyState propertyState;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "property_facility",
        joinColumns = @JoinColumn(name = "property_id"),
        inverseJoinColumns = @JoinColumn(name = "facility_id"))    
    private Set<Facility> facilities;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PropertyComment> comments;

    @OneToMany(mappedBy = "property" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PropertyPhoto> photos;



    @CreatedDate()
    private LocalDateTime CreationDateTime;
}

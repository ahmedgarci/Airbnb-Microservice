package com.AirbnbClone.PropertyService.Comment;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.AirbnbClone.PropertyService.Property.Property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PropertyComment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private Integer commentatorId;

    private String comment;

    @ManyToOne()
    @JoinColumn(name = "property_id",nullable = false)
    @JsonIgnore
    private Property property;

    @CreatedDate()
    private LocalDateTime creationDate;

}

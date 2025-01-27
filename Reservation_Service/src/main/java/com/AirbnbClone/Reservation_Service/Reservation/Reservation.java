package com.AirbnbClone.Reservation_Service.Reservation;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(updatable = false , nullable = false )
    @NotNull(message = "customer Id is required ")
    private Integer customerId;

    @Column(updatable = false , nullable = false )
    @NotNull(message = "property is required")
    private Integer propertyId;

    @Column(updatable = false,nullable=false)
    private Date reservationStartingDate;

    @Column(nullable=false)
    private Integer guests;

    @Column(updatable = false,nullable=false)
    private Date reservationEndingDate;

    @Column(updatable=false,nullable=false)
    private Integer totalPrice;



    

}

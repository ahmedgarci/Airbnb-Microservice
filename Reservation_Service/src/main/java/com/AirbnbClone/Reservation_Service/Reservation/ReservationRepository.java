package com.AirbnbClone.Reservation_Service.Reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository  extends JpaRepository<Reservation,Integer>{

    List<Reservation> findByCustomerId(Integer customerId);
    
}

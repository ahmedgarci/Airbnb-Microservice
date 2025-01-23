package com.AirbnbClone.Reservation_Service.Reservation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.AirbnbClone.Reservation_Service.Requests.BookPropertyRequest;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReservationService {
        private final ReservationRepository reservationRepository;
        private final ReservationMapper reservationMapper;

        public void ReserveAproperty(@NotNull Integer userId, BookPropertyRequest request ){
            // CHECK USER & PROPERTY 
            
            Reservation reservation = reservationMapper.toReservation(request);            
            
            reservationRepository.save(reservation);


            // UPDATE PROPERTY STATE TO BOOKED 
        }


        
      












}

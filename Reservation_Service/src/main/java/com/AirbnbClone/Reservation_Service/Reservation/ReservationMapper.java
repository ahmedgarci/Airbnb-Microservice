package com.AirbnbClone.Reservation_Service.Reservation;

import com.AirbnbClone.Reservation_Service.Requests.BookPropertyRequest;
import com.AirbnbClone.Reservation_Service.Responses.ReservationResponse;
import org.springframework.stereotype.Service;


@Service
public class ReservationMapper {

    public Reservation toReservation (BookPropertyRequest request){
        return Reservation.builder().propertyId(request.getPropertyId()).reservationEndingDate(request.getEndingDate())
        .reservationStartingDate(request.getStartingDate()).totalPrice(request.getTotalPrice()).guests(request.getNumberOfGuests())
        .customerId(request.getCustomerId()).build();
    }

    
}

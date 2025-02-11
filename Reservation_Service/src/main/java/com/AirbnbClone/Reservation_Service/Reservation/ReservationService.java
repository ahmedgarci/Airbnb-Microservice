package com.AirbnbClone.Reservation_Service.Reservation;


import org.springframework.stereotype.Service;

import com.AirbnbClone.Reservation_Service.Client.IPropertyClient;
import com.AirbnbClone.Reservation_Service.Client.IUserClient;
import com.AirbnbClone.Reservation_Service.Exception.EntityNotFoundException;
import com.AirbnbClone.Reservation_Service.Requests.BookPropertyRequest;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReservationService {
    
        private final ReservationRepository reservationRepository;
        private final ReservationMapper reservationMapper;
        private final IPropertyClient propertyClient;
     //   private final IUserClient userClient;

        public void ReserveAproperty(@NotNull Integer userId, BookPropertyRequest request ){
            // to do
           //  userClient.a(request.getCustomerId());
       //     if(!userExists){
       //         System.out.println("unauthorized");
       //     }
            
            boolean PropertyExists = propertyClient.findPropertyById(request.getPropertyId());
            if(!PropertyExists){
                throw new EntityNotFoundException("property was not found");
            }            
            reservationRepository.save(reservationMapper.toReservation(request));
        }
        


}

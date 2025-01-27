package com.AirbnbClone.Reservation_Service.Requests;

import java.util.Date;
import lombok.Getter;


@Getter
public class BookPropertyRequest {
    
    private Integer customerId;

    private Integer propertyId;

    private Date startingDate;

    private Date endingDate;

    private Integer totalPrice;
    
    private Integer NumberOfGuests;

}

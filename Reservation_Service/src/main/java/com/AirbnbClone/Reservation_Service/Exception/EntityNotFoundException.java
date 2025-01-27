package com.AirbnbClone.Reservation_Service.Exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String msg){
        super(msg);}
}

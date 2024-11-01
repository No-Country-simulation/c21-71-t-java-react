package com.bookstore.api_book.model;

public enum ReservationStatus {

    PENDING("PENDING"),
    READY_FOR_PICKUP("READY_FOR_PICKUP"),
    COMPLETED("COMPLETED"),
    EXPIRED("EXPIRED"),
    CANCELED("CANCELED");


    private final String status;

    ReservationStatus(String status){
        this.status = status;
    }

    public String getStatus() {return status;}
}

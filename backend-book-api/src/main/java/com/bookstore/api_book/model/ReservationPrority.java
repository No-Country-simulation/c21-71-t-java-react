package com.bookstore.api_book.model;

public enum ReservationPrority {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int value;

    ReservationPrority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

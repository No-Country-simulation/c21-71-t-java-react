package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.ReservationRequest;
import com.bookstore.api_book.model.Reservation;

import java.util.Optional;

public interface ReservationService {

    void createReservation(ReservationRequest reservation);
    void updateReservation(ReservationRequest updatedReservation, Long id);
    void deleteReservation(Long id);
    Optional<Reservation> getReservation(Long id);
    void returnBook(Long id);
}

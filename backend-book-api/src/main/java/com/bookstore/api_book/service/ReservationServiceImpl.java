package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.ReservationRequest;
import com.bookstore.api_book.model.Reservation;
import com.bookstore.api_book.repository.ReservationsRepository;
import org.springframework.stereotype.Service;


import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationsRepository reservationsRepository;

    public ReservationServiceImpl(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    @Override
    public void createReservation(ReservationRequest reservation) {

        Reservation newReservation = mapToReservation(reservation);
        // create reservation

        reservationsRepository.save(newReservation);
    }

    @Override
    public void updateReservation(ReservationRequest updatedReservation, Long id) {
        if (!isExists(id)) {
            throw new RuntimeException("Reservation not found");
        }
        reservationsRepository.findById(id)
                .ifPresent(reservation -> {
                    Reservation updated = mapToReservation(updatedReservation);
                    updated.setId(reservation.getId());
                    reservationsRepository.save(updated);
                });
    }

    @Override
    public void deleteReservation(Long id) {
        if(!isExists(id)) {
            throw new RuntimeException("Reservation not found");
        }
        reservationsRepository.deleteById(id);
    }

    @Override
    public Optional<Reservation> getReservation(Long id) {
        if (isExists(id)) {
            Optional<Reservation> reservation = reservationsRepository.findById(id);
            if (reservation.isPresent()) {
                return reservation;
            }
        }
        return Optional.empty();
    }

    @Override
    public void returnBook(Long id) {
        if (!isExists(id)) {
            throw new RuntimeException("Reservation not found");
        }
        reservationsRepository.findById(id)
                .ifPresent(reservation -> {
                    reservation.setCompletedAt(ZonedDateTime.now());
                    reservationsRepository.save(reservation);
                });
    }


    private Reservation mapToReservation(ReservationRequest requestReservation) {
        // map to reservation
        Reservation reservation = new Reservation();
        reservation.setUserId(requestReservation.userId());
        reservation.setBookId(requestReservation.bookId());
        reservation.setCreatedAt(requestReservation.createdAt());
        reservation.setExpiresAt(requestReservation.expiresAt());
        reservation.setPickupDeadline(requestReservation.pickupDeadline());
        reservation.setCompletedAt(requestReservation.completedAt());
        reservation.setNotes(requestReservation.notes());

        return reservation;
    }

    private boolean isExists(Long id) {
        return reservationsRepository.existsById(id);
    }
}

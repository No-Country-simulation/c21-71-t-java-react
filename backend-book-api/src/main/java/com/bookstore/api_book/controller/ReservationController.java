package com.bookstore.api_book.controller;

import com.bookstore.api_book.dto.ReservationRequest;
import com.bookstore.api_book.model.Reservation;
import com.bookstore.api_book.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/")
    public ResponseEntity<String> createReservation(@RequestBody ReservationRequest reservation) {
        // create reservation
        try {
            reservationService.createReservation(reservation);
            return ResponseEntity.ok("Reservation created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateReservation(@RequestBody ReservationRequest reservation, @PathVariable long id) {
        // update reservation
        try {
            reservationService.updateReservation(reservation,id);
            return ResponseEntity.ok("Reservation updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable long id) {
        // delete reservation
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.ok("Reservation deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable long id) {
        try {
            Optional<Reservation> found = reservationService.getReservation(id);
            if (found.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(found.get());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping("/{reservationId}/return")
    public ResponseEntity<String> returnReservation(@PathVariable Long reservationId) {
        try{
            reservationService.returnBook(reservationId);
            return ResponseEntity.ok("Book returned successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}

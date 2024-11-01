package com.bookstore.api_book.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Table(name = "reservations")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long bookId;
    private ReservationStatus status;
    private ReservationPrority priority;
    private ZonedDateTime  createdAt;
    private ZonedDateTime  expiresAt;
    private ZonedDateTime pickupDeadline;
    private ZonedDateTime completedAt;
    private String notes = "";
}

package com.bookstore.api_book.dto;

import com.bookstore.api_book.model.ReservationPrority;
import com.bookstore.api_book.model.ReservationStatus;

import java.time.ZonedDateTime;

public record ReservationRequest (
        Long userId,
        Long bookId,
        ReservationStatus status,
        ReservationPrority priority,
        ZonedDateTime createdAt,
        ZonedDateTime  expiresAt,
        ZonedDateTime pickupDeadline,
        ZonedDateTime completedAt,
        String notes
) { }

package com.bookstore.api_book.repository;

import com.bookstore.api_book.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservation, Long> {

}

package com.bookstore.api_book.repository;

import com.bookstore.api_book.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository  extends JpaRepository<Genre, Long> {
}

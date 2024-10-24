package com.bookstore.api_book.repository;

import com.bookstore.api_book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {
}

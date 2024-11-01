package com.bookstore.api_book.repository;

import com.bookstore.api_book.dto.BookResponseDto;
import com.bookstore.api_book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {


@Query("SELECT new com.bookstore.api_book.dto.BookResponseDto(b.title, b.authorId, b.year, b.stock, COUNT(l)) " +
        "FROM Book b LEFT JOIN Loan l ON b.id = l.book.id " +
       "WHERE l.status IS NULL OR l.status NOT IN (com.bookstore.api_book.model.LoanStatus.RETURNED)"  +
        "GROUP BY b.id, b.title, b.year, b.stock")
    Page<BookResponseDto> getAllBooksDto(Pageable pageable);

}

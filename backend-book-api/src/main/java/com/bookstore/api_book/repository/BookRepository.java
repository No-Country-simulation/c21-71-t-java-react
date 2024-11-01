package com.bookstore.api_book.repository;

import com.bookstore.api_book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository  extends JpaRepository<Book, Long> {

    @Query("SELECT DISTINCT b FROM Book b LEFT JOIN b.genres g " +
            "WHERE (:term IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :term, '%'))) " +
            "AND (:genreIds IS NULL OR g.genreId IN :genreIds)")
    List<Book> searchBooks(
            @Param("term") String term,
            @Param("genreIds") List<Long> genreIds);

}

package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.BookRequest;
import com.bookstore.api_book.dto.BookResponse;
import com.bookstore.api_book.dto.BookResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    void addBook(BookRequest book);

    void updateBook(BookRequest updatedBook, Long id);

    void deleteBook(Long id);

    Page<BookResponse> getAllBooks(Pageable pageable);

    List<BookResponseDto> getAllBooksDto();

    BookResponse getBook(Long id);

    List<BookResponse> getBooks();
}

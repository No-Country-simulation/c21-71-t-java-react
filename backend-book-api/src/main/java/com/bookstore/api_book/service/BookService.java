package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.BookRequest;
import com.bookstore.api_book.dto.BookResponse;

import java.util.List;

public interface BookService {

    void addBook(BookRequest book);

    void updateBook(BookRequest updatedBook, Long id);

    void deleteBook(Long id);

    BookResponse getBook(Long id);

    List<BookResponse> getBooks();
}

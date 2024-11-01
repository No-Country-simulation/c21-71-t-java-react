package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.AuthorRequest;
import com.bookstore.api_book.dto.AuthorResponse;

public interface AuthorService {

    void addAuthor(AuthorRequest authorRequest);

    void updateAuthor(AuthorRequest updatedAuthor, Long id);

    void deleteAuthor(Long id);

    AuthorResponse getAuthorById(Long id);
}

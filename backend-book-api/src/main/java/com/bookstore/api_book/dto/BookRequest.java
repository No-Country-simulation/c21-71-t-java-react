package com.bookstore.api_book.dto;

import com.bookstore.api_book.model.Genre;

import java.util.Set;

public record BookRequest(String title,
                          int year,
                          String isbn,
                          Set<Genre> genres,
                          int publisherId,
                          String format,
                          int pages,
                          int stock,
                          String description,
                          int authorId,
                          String language
) { }

package com.bookstore.api_book.dto;

import com.bookstore.api_book.model.Genre;

import java.util.Set;

public record BookResponse(String title,
                           int year,
                           String isbn,
                           Set<String> genres,
                           String publisher,
                           String format,
                           int pages,
                           int stock,
                           String description,
                           String author
) { }

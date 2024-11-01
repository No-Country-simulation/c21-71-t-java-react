package com.bookstore.api_book.dto;

import com.bookstore.api_book.model.Genre;

import java.util.Set;

public record BookRequest(String title,

                          int year,

                          String isbn,

                          //TODO possible create array of genres
                          Set<Genre> genres,

                          //TODO possible create a new table for publisherId
                          int publisherId,

                          String format,

                          int pages,

                          int stock,

                          String description,
                          int authorId,
                          String language
) { }

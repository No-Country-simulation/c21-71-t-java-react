package com.bookstore.api_book.dto;

public record BookRequest(String title,

                          int year,

                          String isbn,

                          //TODO possible create array of genres
                          String genre,

                          //TODO possible create a new table for publisherId
                          int publisherId,

                          String format,

                          int pages,

                          int stock,

                          String description,
int authorId) {
}

package com.bookstore.api_book.dto;

public record AuthorRequest(
        String name,
        String lastName,
        String nationality,
        String biography,
        String birthday
) { }

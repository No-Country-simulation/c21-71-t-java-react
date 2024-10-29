package com.bookstore.api_book.dto;

public record UserResponse(
        Long id,

        String name,

        String lastName,

        String email,

        String password
) { }

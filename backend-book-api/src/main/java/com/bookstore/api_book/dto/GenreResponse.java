package com.bookstore.api_book.dto;

import java.time.LocalDateTime;

public record GenreResponse(
        String genreName,
        String genreDescription,
        LocalDateTime createdAt
) { }

package com.bookstore.api_book.dto;

import java.time.LocalDateTime;

public record GenreRequest(
         String genreName,
         String genreDescription
) { }

package com.bookstore.api_book.dto;

public record PublisherResponse(
        String name,
        String country,
        int year_created,
        String description
) {
}

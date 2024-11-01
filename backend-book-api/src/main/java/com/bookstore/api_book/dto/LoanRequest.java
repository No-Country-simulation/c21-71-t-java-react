package com.bookstore.api_book.dto;

public record LoanRequest(
        Long bookId,
        String email
) {
}

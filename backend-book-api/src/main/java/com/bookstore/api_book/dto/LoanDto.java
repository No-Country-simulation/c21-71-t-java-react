package com.bookstore.api_book.dto;

import java.time.LocalDate;

public record LoanDto(
        Long id,
        Long bookId,
        LocalDate loanDate,
        LocalDate returnDate
) {
}

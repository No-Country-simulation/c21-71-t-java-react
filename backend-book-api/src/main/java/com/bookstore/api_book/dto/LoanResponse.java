package com.bookstore.api_book.dto;

import java.time.LocalDate;

public record LoanResponse(
    String userName,
    String bookName,
    LocalDate loanDate,
    LocalDate returnDate
) {
}

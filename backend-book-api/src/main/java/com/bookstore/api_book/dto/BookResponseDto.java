package com.bookstore.api_book.dto;

public record BookResponseDto(
        String title,
        String autor,
        int year,
        int stock,
        long unidadesPrestadas
) {
}

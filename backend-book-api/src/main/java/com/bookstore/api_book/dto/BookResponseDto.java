package com.bookstore.api_book.dto;

public record BookResponseDto(
        String title,
        int autorId,
        int year,
        int stock,
        long unidadesPrestadas
) {
}

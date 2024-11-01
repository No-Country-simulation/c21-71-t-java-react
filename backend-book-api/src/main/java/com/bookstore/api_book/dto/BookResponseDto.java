package com.bookstore.api_book.dto;

public record BookResponseDto(
        String titulo,
        int autorId,
        int year,
        int unidadesDisponibles,
        long unidadesPrestadas
) {
}

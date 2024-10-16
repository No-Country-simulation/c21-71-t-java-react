package com.bookstore.api_book.dto;

public record RegisterRequest(String name, String lastName, String email, String password) {
}

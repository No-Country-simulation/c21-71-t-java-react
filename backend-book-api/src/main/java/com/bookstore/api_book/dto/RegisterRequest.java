package com.bookstore.api_book.dto;

public record RegisterRequest(String name, String username, String lastName, String email, String password) {
}

package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.UserResponse;

public interface UserService {

     void deleteUser(Long id);

     void updatePassword(Long id, String password);

     UserResponse getUserById(Long id);
}

package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.UserResponse;

public interface UserService {

import com.bookstore.api_book.model.User;
import com.bookstore.api_book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

     void deleteUser(Long id);

     void updatePassword(Long id, String password);
    private final UserRepository userRepository;

     UserResponse getUserById(Long id);

     void updatedUser(Long id, String name, String lastName, String email);

}

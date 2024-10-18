package com.bookstore.api_book.service;

import javax.management.RuntimeErrorException;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookstore.api_book.dto.LoginRequest;
import com.bookstore.api_book.dto.RegisterRequest;
import com.bookstore.api_book.model.User;
import com.bookstore.api_book.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public void registerUser(RegisterRequest registerRequest) {

        if (userRepository.findByEmail(registerRequest.email()).isPresent()) {
            //TODO: make exception
            throw new RuntimeException("Username already taken");
        }

        User user = User.builder()
                .name(registerRequest.name())
                .lastName(registerRequest.lastName())
                .email(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .build();

        userRepository.save(user);
    }

}

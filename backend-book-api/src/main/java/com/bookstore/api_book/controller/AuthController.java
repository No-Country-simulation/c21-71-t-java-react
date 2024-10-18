package com.bookstore.api_book.controller;

import com.bookstore.api_book.dto.LoginRequest;
import com.bookstore.api_book.dto.RegisterRequest;
import com.bookstore.api_book.repository.UserRepository;
import com.bookstore.api_book.service.AuthService;
import com.bookstore.api_book.service.JwtService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            String token = authService.loginUser(loginRequest);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            //TODO: make exception
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email/password supplied");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        try {
            authService.registerUser(request);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            //TODO: make exception
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}

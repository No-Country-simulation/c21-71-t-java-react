package com.bookstore.api_book.service;


import com.bookstore.api_book.dto.LoginRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookstore.api_book.dto.RegisterRequest;
import com.bookstore.api_book.model.User;
import com.bookstore.api_book.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
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

    public String loginUser(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.email())
                .orElseThrow(() -> new RuntimeException("User not found"));



        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

        System.out.println("AuthService login " + auth.getName());
        String token = jwtService.generateToken(auth.getName());

        return token;

    }

}

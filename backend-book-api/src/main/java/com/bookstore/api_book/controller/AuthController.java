package com.bookstore.api_book.controller;

import com.bookstore.api_book.dto.LoginRequest;
import com.bookstore.api_book.dto.RegisterRequest;
import com.bookstore.api_book.model.User;
import com.bookstore.api_book.repository.UserRepository;
import com.bookstore.api_book.service.AuthService;
import com.bookstore.api_book.service.JwtService;
import com.bookstore.api_book.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, Authentication auth) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }


        String token = jwtService.generateToken(loginRequest.email());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        

        System.out.println(authentication.getPrincipal()+ " logged in");
     
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        
        authService.registerUser(request);

        return ResponseEntity.ok("User registered successfully");
    }
}

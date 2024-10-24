package com.bookstore.api_book.controller;

import com.bookstore.api_book.dto.UpdatePasswordRequest;
import com.bookstore.api_book.dto.UserResponse;
import com.bookstore.api_book.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteUser(
            @PathVariable Long id,
            Authentication authentication
    ) {
        try {
            String authenticatedUsername = authentication.getName();

            UserResponse userToUpdate = userServiceImpl.getUserById(id);

            boolean isSameUser = userToUpdate.email().equals(authenticatedUsername);


            if (!isSameUser) {
                return ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .body("No tienes permisos para eliminar este usuario");
            }

            userServiceImpl.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String>updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequest updatePasswordRequest,
            Authentication authentication
    ) {
        try {
            // Move to own method
            // get the authenticated user
            String authenticatedUsername = authentication.getName();

            // get the user to update
            UserResponse userToUpdate = userServiceImpl.getUserById(id);

            boolean isSameUser = userToUpdate.email().equals(authenticatedUsername);

            if (!isSameUser) {
                return ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .body("No tienes permisos para cambiar esta contraseña");
            }
            userServiceImpl.updatePassword(id, (updatePasswordRequest.password()));
            return ResponseEntity.ok("Password updated successfully");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}

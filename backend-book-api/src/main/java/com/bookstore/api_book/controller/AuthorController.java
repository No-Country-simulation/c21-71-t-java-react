package com.bookstore.api_book.controller;

import com.bookstore.api_book.dto.AuthorRequest;
import com.bookstore.api_book.dto.AuthorResponse;
import com.bookstore.api_book.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<String> addAuthor(@RequestBody AuthorRequest authorRequest) {
        authorService.addAuthor(authorRequest);
        return ResponseEntity.ok("Author added");
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable Long id) {
        AuthorResponse author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthor(@RequestBody AuthorRequest updatedAuthor, @PathVariable Long id) {
        authorService.updateAuthor(updatedAuthor, id);
        return ResponseEntity.ok("Author updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok("Author deleted");
    }


}

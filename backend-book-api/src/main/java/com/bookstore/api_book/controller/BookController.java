package com.bookstore.api_book.controller;

import com.bookstore.api_book.dto.BookRequest;
import com.bookstore.api_book.dto.BookResponse;
import com.bookstore.api_book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Add a new book
    // POST /api/v1/books
    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody BookRequest book) {
        bookService.addBook(book);
        return new ResponseEntity<>("Book added", HttpStatus.CREATED);
    }


    // Update a book
    // PUT /api/v1/books/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@RequestBody BookRequest book, @PathVariable Long id) {
        try {
            bookService.updateBook(book, id);
            return new ResponseEntity<>("Book updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
    }

    // Delete a book
    // DELETE /api/v1/books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return new ResponseEntity<>("Book deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }

    }

    // Get a book
    // GET /api/v1/books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long id) {
        try {
            BookResponse foundBook = bookService.getBook(id);
            return ResponseEntity.ok().body(foundBook);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Get all books
    // GET /api/v1/books
    @GetMapping
    public ResponseEntity<List<BookResponse>> getBooks() {
        List<BookResponse> books = bookService.getBooks();
        return ResponseEntity.ok().body(books);
    }


}
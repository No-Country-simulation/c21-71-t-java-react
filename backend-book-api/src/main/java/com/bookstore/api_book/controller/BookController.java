package com.bookstore.api_book.controller;

import com.bookstore.api_book.dto.BookRequest;
import com.bookstore.api_book.dto.BookResponse;
import com.bookstore.api_book.dto.BookResponseDto;
import com.bookstore.api_book.dto.SearchRequest;
import com.bookstore.api_book.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin(originPatterns = "*")
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
    public Page<BookResponse> getBooks(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        return bookService.getAllBooks(pageable);
    }

    @GetMapping("/test")
    public Page<BookResponseDto> getBooksDto(@PageableDefault(page = 0, size = 5) Pageable pageable){
        return bookService.getAllBooksDto(pageable);
    }
    @GetMapping("/search")
    public ResponseEntity<List<BookResponse>> searchBooks(
           @RequestBody SearchRequest request) {

        List<BookResponse> resultados = bookService.searchBooks(request.getSearchTerm(), request.getGenreIds());
        return ResponseEntity.ok(resultados);
    }


}

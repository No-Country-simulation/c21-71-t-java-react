package com.bookstore.api_book.controller;

import com.bookstore.api_book.dto.GenreRequest;
import com.bookstore.api_book.dto.GenreResponse;
import com.bookstore.api_book.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public ResponseEntity<String> addGenre(@RequestBody GenreRequest genreRequest) {
        genreService.addGenre(genreRequest);
        return ResponseEntity.ok("Genre added: ");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getGenreById(@PathVariable Long id) {
        GenreResponse genre = genreService.getGenreById(id);
        return ResponseEntity.ok(genre.toString());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGenre(@RequestBody GenreRequest updatedGenre, @PathVariable Long id) {
        genreService.updateGender(updatedGenre, id);
        return ResponseEntity.ok("Genre updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable Long id) {
        genreService.deleteGender(id);
        return ResponseEntity.ok("Genre deleted");
    }


}

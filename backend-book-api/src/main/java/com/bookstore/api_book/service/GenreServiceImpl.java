package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.GenreRequest;
import com.bookstore.api_book.dto.GenreResponse;
import com.bookstore.api_book.model.Genre;
import com.bookstore.api_book.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genderRepository;

    public GenreServiceImpl(GenreRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public void addGenre(GenreRequest genreRequest) {
        Genre newGenre = mapToGenre(genreRequest);
        genderRepository.save(newGenre);

    }

    @Override
    public void updateGender(GenreRequest updatedGenre, Long id) {
        if (!genderRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        genderRepository.findById(id)
                .ifPresent(book -> {
                        Genre updated = mapToGenre(updatedGenre);
                    updated.setGenreId(book.getGenreId());
                    genderRepository.save(updated);
                });

    }

    @Override
    public void deleteGender(Long id) {

        if (!genderRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        genderRepository.deleteById(id);

    }

    @Override
    public GenreResponse getGenreById(Long id) {
        if (genderRepository.existsById(id)) {
            Genre genre = genderRepository.findById(id).get();
            return mapGenreToResponse(genre);
        } else {
            throw new RuntimeException("Genre not found");
        }

    }

    private Genre mapToGenre(GenreRequest genreRequest) {
        Genre newGenre = new Genre();
        newGenre.setGenreDescription(genreRequest.genreName());
        newGenre.setGenreName(genreRequest.genreDescription());
        newGenre.setCreatedAt(LocalDateTime.now());
        return newGenre;
    }

    private GenreResponse mapGenreToResponse(Genre genre) {
        return new GenreResponse(genre.getGenreName(), genre.getGenreDescription(), genre.getCreatedAt());
    }
}

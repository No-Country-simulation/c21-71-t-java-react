package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.GenreRequest;
import com.bookstore.api_book.dto.GenreResponse;

public interface GenreService {

    void addGenre(GenreRequest genreRequest);

    void updateGender(GenreRequest genreRequest, Long id);

    void deleteGender(Long id);

    GenreResponse getGenreById(Long id);


}

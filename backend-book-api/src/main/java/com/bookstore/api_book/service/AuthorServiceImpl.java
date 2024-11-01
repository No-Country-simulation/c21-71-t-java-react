package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.AuthorRequest;
import com.bookstore.api_book.dto.AuthorResponse;
import com.bookstore.api_book.model.Author;
import com.bookstore.api_book.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void addAuthor(AuthorRequest authorRequest) {
        Author newAuthor = mapToAuthor(authorRequest);
        authorRepository.save(newAuthor);
    }

    @Override
    public void updateAuthor(AuthorRequest updatedAuthor, Long id) {
        if(!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found");
        }
        authorRepository.findById(id)
                .ifPresent(author -> {
                    Author updated = mapToAuthor(updatedAuthor);
                    updated.setId(author.getId());
                    authorRepository.save(updated);
                });

    }

    @Override
    public void deleteAuthor(Long id) {
        if(!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found");
        }
        authorRepository.deleteById(id);

    }

    @Override
    public AuthorResponse getAuthorById(Long id) {
        if(authorRepository.existsById(id)) {
            Optional<Author> author = authorRepository.findById(id);
            if (author.isPresent()) {
                return mapToAuthorResponse(author.get());
            }
        }
        throw new RuntimeException("Author not found");

    }

    private Author mapToAuthor(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setName(authorRequest.name());
        author.setLastName(authorRequest.lastName());
        author.setNationality(authorRequest.nationality());
        author.setBiography(authorRequest.biography());
        author.setBirthday(authorRequest.biography());
        return author;
    }

    private AuthorResponse mapToAuthorResponse(Author author) {
        return  new AuthorResponse(
                author.getName(),
                author.getLastName(),
                author.getNationality(),
                author.getBiography(),
                author.getBirthday()
        );
    }
}

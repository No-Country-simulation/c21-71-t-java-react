package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.BookRequest;
import com.bookstore.api_book.dto.BookResponse;
import com.bookstore.api_book.dto.BookResponseDto;
import com.bookstore.api_book.model.Author;
import com.bookstore.api_book.model.Book;
import com.bookstore.api_book.model.Genre;
import com.bookstore.api_book.model.Publisher;
import com.bookstore.api_book.repository.AuthorRepository;
import com.bookstore.api_book.repository.BookRepository;
import com.bookstore.api_book.repository.GenreRepository;
import com.bookstore.api_book.repository.PublisherRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public BookServiceImpl(BookRepository bookRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public void addBook(BookRequest book) {
        Book newBook = mapToBook(book);
        bookRepository.save(newBook);
    }

    @Override
    public void updateBook(BookRequest updatedBook, Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.findById(id)
                .ifPresent(book -> {
                   Book updated = mapToBook(updatedBook);
                   updated.setId(book.getId());
                     bookRepository.save(updated);
                });
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }

    @Override
    public BookResponse getBook(Long id) {
        if (bookRepository.existsById(id)) {
            Optional<Book> book = bookRepository.findById(id);
            if (book.isPresent()) {
                return mapToBookResponse(book.get());
            }
        }
        return null;
    }

    @Override
    public Page<BookResponse> getAllBooks(Pageable pageable) {
        Page<Book> booksPage = bookRepository.findAll(pageable);

        return booksPage.map(this::mapToBookResponse);
    }

    @Override
    public Page<BookResponseDto> getAllBooksDto(Pageable pageable) {
        Page<BookResponseDto> booksPage = bookRepository.getAllBooksDto(pageable);
        return booksPage;
    }

    @Override
    public List<BookResponse> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(this::mapToBookResponse)
                .collect(Collectors.toList());
    }

    public List<BookResponse> searchBooks(String term, List<Long> genreIds) {
        List<Book> books;
        if (genreIds == null || genreIds.isEmpty()) {
            books = bookRepository.searchBooks(term, null);
        } else {
            books = bookRepository.searchBooks(term, genreIds);
        }
        return books.stream()
                .map(this::mapToBookResponse)
                .collect(Collectors.toList());
    }


    private BookResponse mapToBookResponse(Book book) {
        return new BookResponse(
                book.getTitle(),
                book.getYear(),
                book.getIsbn(),
                book.getGenres().stream()
                        .map(Genre::getGenreName)
                        .collect(Collectors.toSet()),
                book.getPublisher() != null ? book.getPublisher().getName(): null,
                book.getFormat(),
                book.getPages(),
                book.getStock(),
                book.getDescription(),
                book.getAuthor() != null ? book.getAuthor().getName() + " " + book.getAuthor().getLastName() : null
        );
    }

    private Book mapToBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.title());
        book.setYear(bookRequest.year());
        book.setIsbn(bookRequest.isbn());
        book.setGenres(validateGenres(bookRequest.genres()));
        if (bookRequest.publisherId() != 0) {
            Publisher publisher = publisherRepository.findById((long) bookRequest.publisherId())
                    .orElseThrow(() -> new RuntimeException("Publisher not found"));
            book.setPublisher(publisher);
        }        book.setFormat(bookRequest.format());
        book.setPages(bookRequest.pages());
        book.setLanguage(bookRequest.language());
        book.setStock(bookRequest.stock());
        book.setGenres(bookRequest.genres());
        book.setDescription(bookRequest.description());
        if (bookRequest.authorId() != 0) {
            Author author = authorRepository.findById((long) bookRequest.authorId())
                    .orElseThrow(() -> new RuntimeException("Author not found"));
            book.setAuthor(author);
        }
        return book;
    }

    private Set<Genre> validateGenres(Set<Genre> genres) {
        return genres.stream()
                .map(genre -> genreRepository.findById(genre.getGenreId())
                        .orElseThrow(() -> new RuntimeException("Genre not found: " + genre.getGenreId())))
                .collect(Collectors.toSet());
    }

}



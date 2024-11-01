package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.BookRequest;
import com.bookstore.api_book.dto.BookResponse;
import com.bookstore.api_book.dto.BookResponseDto;
import com.bookstore.api_book.model.Book;
import com.bookstore.api_book.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
    public List<BookResponseDto> getAllBooksDto() {
        List<BookResponseDto> booksPage = bookRepository.getAllBooks();
        return booksPage;
    }

    @Override
    public List<BookResponse> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(this::mapToBookResponse)
                .collect(Collectors.toList());
    }

    private BookResponse mapToBookResponse(Book book) {
        return new BookResponse(book.getTitle(), book.getYear(), book.getIsbn(), book.getGenre(), book.getPublishedId(), book.getFormat(), book.getPages(), book.getStock(), book.getDescription(), book.getAuthorId());
    }

    private Book mapToBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.title());
        book.setYear(bookRequest.year());
        book.setIsbn(bookRequest.isbn());
        book.setGenre(bookRequest.genre());
        book.setPublishedId(bookRequest.publisherId());
        book.setFormat(bookRequest.format());
        book.setPages(bookRequest.pages());
        book.setStock(bookRequest.stock());
        book.setDescription(bookRequest.description());
        book.setAuthorId(bookRequest.authorId());

        return book;
    }

}



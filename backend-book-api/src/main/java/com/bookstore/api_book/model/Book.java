package com.bookstore.api_book.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Table(name = "books")
@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int year;

    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    private String format;

    private int pages;

    private int stock;

    private String description;

    private String language;

    private String imageUrL;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "genre_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<Loan> loans;

    public boolean hasStock(){
        return stock > 0;
    }

    public void reduceStock(){
        if (stock > 0){
            stock--;
        }else {
            throw new RuntimeException("Stock is empty");
        }
    }

    public void increaseStock(){
        stock++;
    }

}

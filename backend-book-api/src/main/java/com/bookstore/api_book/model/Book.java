package com.bookstore.api_book.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    //TODO possible create array of genres
    private String genre;

    //TODO possible create a new table for publisherId
    private int publishedId;

    private String format;

    private int pages;

    private int stock;

    private String description;

    private int authorId;

    private String language;

    private String imageUrL;

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

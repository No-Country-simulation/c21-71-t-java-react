package com.bookstore.api_book.model;

import jakarta.persistence.*;

@Table(name = "authors")
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String nationality;
    private String biography;
    private String birthday;

}

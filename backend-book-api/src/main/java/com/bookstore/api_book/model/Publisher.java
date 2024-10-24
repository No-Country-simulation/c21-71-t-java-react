package com.bookstore.api_book.model;

import jakarta.persistence.*;

@Table(name = "publishers")
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;

    private int year_created;
    private String description;

}

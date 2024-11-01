package com.bookstore.api_book.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "authors")
@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String nationality;
    private String biography;
    private String birthday;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private Set<Book> books;

}

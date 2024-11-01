package com.bookstore.api_book.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "publishers")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;

    private int year_created;
    private String description;

    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private Set<Book> books;
}

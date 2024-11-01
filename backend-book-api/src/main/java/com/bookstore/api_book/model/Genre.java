package com.bookstore.api_book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "genres")
@Getter
@Setter
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long genreId;
    private String genreName;
    private String genreDescription;
    private LocalDateTime createdAt;

    public Genre(Long genreId) {
        this.genreId = genreId;
    }

}

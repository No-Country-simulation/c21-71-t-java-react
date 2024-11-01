package com.bookstore.api_book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {
    private String searchTerm;
    private List<Long> genreIds;
}

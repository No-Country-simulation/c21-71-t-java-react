package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.PublisherRequest;
import com.bookstore.api_book.dto.PublisherResponse;

public interface PublisherService {

    void addPublisher(PublisherRequest publisherRequest);

    PublisherResponse getPublisherById(Long id);

    void updatePublisher(PublisherRequest updatedPublisher, Long id);

    void deletePublisher(Long id);
}

package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.PublisherRequest;
import com.bookstore.api_book.dto.PublisherResponse;
import com.bookstore.api_book.model.Publisher;
import com.bookstore.api_book.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void addPublisher(PublisherRequest publisherRequest) {
        Publisher newPublisher = mapToPublisher(publisherRequest);
        publisherRepository.save(newPublisher);
    }

    @Override
    public PublisherResponse getPublisherById(Long id) {
        if(publisherRepository.existsById(id)) {
            Optional<Publisher> author = publisherRepository.findById(id);
            if (author.isPresent()) {
                return mapToPublisherResponse(author.get());
            }
        }
        throw new RuntimeException("Author not found");

    }

    @Override
    public void updatePublisher(PublisherRequest updatedPublisher, Long id) {
        if(!publisherRepository.existsById(id)) {
            throw new RuntimeException("Publisher not found");
        }
        publisherRepository.findById(id)
                .ifPresent(publisher -> {
                    Publisher updated = mapToPublisher(updatedPublisher);
                    updated.setId(publisher.getId());
                    publisherRepository.save(updated);
                });

    }

    @Override
    public void deletePublisher(Long id) {
        if(!publisherRepository.existsById(id)) {
            throw new RuntimeException("Publisher not found");
        }
        publisherRepository.deleteById(id);

    }

    private Publisher mapToPublisher(PublisherRequest publisherRequest) {
        Publisher newPublisher = new Publisher();
        newPublisher.setName(publisherRequest.name());
        newPublisher.setCountry(publisherRequest.country());
        newPublisher.setYear_created(publisherRequest.year_created());
        newPublisher.setDescription(publisherRequest.description());
        return newPublisher;
    }

    private PublisherResponse mapToPublisherResponse(Publisher publisher) {
        return new PublisherResponse(publisher.getName(), publisher.getCountry(), publisher.getYear_created(), publisher.getDescription());
    }
}

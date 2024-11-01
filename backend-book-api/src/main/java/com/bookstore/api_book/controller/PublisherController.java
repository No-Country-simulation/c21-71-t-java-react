package com.bookstore.api_book.controller;

import com.bookstore.api_book.dto.PublisherRequest;
import com.bookstore.api_book.dto.PublisherResponse;
import com.bookstore.api_book.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public ResponseEntity<String> addPublisher(@RequestBody PublisherRequest publisherRequest) {

        publisherService.addPublisher(publisherRequest);

        return ResponseEntity.ok("Publisher added");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponse> getPublisherById(@PathVariable Long id) {

        PublisherResponse publisher = publisherService.getPublisherById(id);
        return ResponseEntity.ok(publisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePublisher(@RequestBody PublisherRequest updatedPublisher, @PathVariable Long id) {

        publisherService.updatePublisher(updatedPublisher, id);
        return ResponseEntity.ok("Publisher updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable Long id) {

        publisherService.deletePublisher(id);
        return ResponseEntity.ok("Publisher deleted");
    }
}

package nl.novi.repository.controllers;

import nl.novi.repository.helpers.UrlHelper;
import nl.novi.repository.entities.PublisherEntity;
import nl.novi.repository.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;
    private final UrlHelper urlHelper;

    public PublisherController(PublisherService publisherService, UrlHelper urlHelper) {
        this.publisherService = publisherService;
        this.urlHelper = urlHelper;
    }

    // GET
    @GetMapping
    public ResponseEntity<List<PublisherEntity>> getAllPublishers() {
        List<PublisherEntity> publishers = publisherService.findAllPublishers();
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherEntity> getPublisherById(@PathVariable Long id) {
        PublisherEntity publisher = publisherService.findPublisherById(id);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<PublisherEntity> createPublisher(@RequestBody PublisherEntity publisherInput) {
        PublisherEntity newPublisher = publisherService.createPublisher(publisherInput);
        return ResponseEntity.created(urlHelper.getCurrentUrlWithId(newPublisher.getId())).body(newPublisher);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<PublisherEntity> updatePublisherById(@PathVariable Long id, @RequestBody PublisherEntity publisherInput) {
        PublisherEntity updatedPublisher = publisherService.updatePublisher(id, publisherInput);
        return new ResponseEntity<>(updatedPublisher, HttpStatus.OK);

    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<PublisherEntity> deletePublisherById(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

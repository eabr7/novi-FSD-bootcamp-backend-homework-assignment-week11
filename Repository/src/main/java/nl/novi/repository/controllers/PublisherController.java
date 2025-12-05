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
        return new ResponseEntity<>(newPublisher, HttpStatus.CREATED);
        return ResponseEntity.created(urlHelper.getCurrentUrlWithId(newPublisher.getId())).build();
    }

    // PUT




    @PutMapping("/{id}")
    public ResponseEntity<GenreEntity> updateGenre(@PathVariable Long id, @RequestBody GenreEntity genreInput) {
        GenreEntity updatedGenre = genreService.updateGenre(id, genreInput);
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}

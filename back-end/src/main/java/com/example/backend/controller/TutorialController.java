package com.example.backend.controller;

import com.example.backend.model.Tutorial;
import com.example.backend.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/tutorials")
public class TutorialController {
    @Autowired
    TutorialService tutorialService;

    @GetMapping()
    public ResponseEntity<Iterable<Tutorial>> findAll() {
        Iterable<Tutorial> iterable = tutorialService.findAll();
        return new ResponseEntity<>(iterable, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Iterable<Tutorial>> findAllSearch(@PathVariable String title){
        Iterable<Tutorial> iterableSearched = tutorialService.findAllByTitle(title);
        return new ResponseEntity<>(iterableSearched, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Tutorial>> findById(@PathVariable Long id) {
        Optional<Tutorial> tutorial = tutorialService.findById(id);
        if (!tutorial.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Tutorial> save(@RequestBody Tutorial tutorial, UriComponentsBuilder builder) {
        tutorialService.create(tutorial);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/person/{id}").buildAndExpand(person.getId()).toUri());
        return new ResponseEntity<>(tutorial, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tutorial> edit(@PathVariable Long id, @RequestBody Tutorial tutorial){
        Optional<Tutorial> currentTutorial = tutorialService.findById(id);
        if (!currentTutorial.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        currentTutorial.get().setTitle(tutorial.getTitle());
        tutorialService.create(currentTutorial.get());
        return new ResponseEntity<>(currentTutorial.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Tutorial> delete(@PathVariable Long id){
        tutorialService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

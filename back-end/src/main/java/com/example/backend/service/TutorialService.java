package com.example.backend.service;

import com.example.backend.model.Tutorial;

import java.util.Optional;

public interface TutorialService {
    Optional<Tutorial> findById(Long id);

    Iterable<Tutorial> findAll();

    void create(Tutorial tutorial);

    void deleteById(Long id);

    Iterable<Tutorial> findAllByTitle(String title);
}

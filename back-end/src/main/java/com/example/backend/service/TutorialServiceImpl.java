package com.example.backend.service;

import com.example.backend.model.Tutorial;
import com.example.backend.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService {
    @Autowired
    TutorialRepository tutorialRepository;

    @Override
    public Optional<Tutorial> findById(Long id) {
        return tutorialRepository.findById(id);
    }

    @Override
    public Iterable<Tutorial> findAll() {
        return tutorialRepository.findAll();
    }

    @Override
    public void create(Tutorial tutorial) {
        tutorialRepository.save(tutorial);
    }

    @Override
    public void deleteById(Long id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public Iterable<Tutorial> findAllByTitle(String title) {
        return tutorialRepository.findAllByTitle(title);
    }

}

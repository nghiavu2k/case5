package com.example.backend.repository;

import com.example.backend.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    Iterable<Tutorial> findAllByTitle(String title);
}

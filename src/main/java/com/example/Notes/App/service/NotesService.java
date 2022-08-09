package com.example.Notes.App.service;

import com.example.Notes.App.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class NotesService {
    @Autowired
    NotesRepository repository;

    @Autowired
    public NotesService(NotesRepository repository) {
        this.repository = repository;
    }


}

package com.example.Notes.App.service;

import com.example.Notes.App.domain.Notes;
import com.example.Notes.App.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesService {
    @Autowired
    NotesRepository repository;

    @Autowired
    public NotesService(NotesRepository repository) {
        this.repository = repository;
    }

    public boolean createNotes(String name, String description) {
        boolean result = false;

        if(name.length()>0){
            Notes notes = new Notes(name,description);
            result = true;
            repository.saveNotes(notes);
        }
        return result;
    }

}

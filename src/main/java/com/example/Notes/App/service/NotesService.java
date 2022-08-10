package com.example.Notes.App.service;

import com.example.Notes.App.controller.Mapper.NotesMapper;
import com.example.Notes.App.domain.Notes;
import com.example.Notes.App.dtos.NotesDTO;
import com.example.Notes.App.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotesService {
    @Autowired
    NotesRepository repository;

    @Autowired
    NotesMapper mapper;

    public NotesService(NotesRepository repository, NotesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public boolean createNotes(String name, String description) {
        boolean result = false;

        if (name.length() > 0) {
            Notes notes = new Notes(name, description);
            result = true;
            repository.saveNotes(notes);
        }
        return result;
    }

    public List<NotesDTO> findAllNotes() {
        List<Notes> notes = repository.findAllNotes();
        List<NotesDTO> notesDTO = new ArrayList<>();

        for (Notes note : notes) {
            NotesDTO noteDTO = mapper.toDTO(note);
            notesDTO.add(noteDTO);
        }
        return notesDTO;
    }

    public boolean deleteById(Long id) {
        boolean result = false;
        if (repository.existsById(id)) {
            repository.deleteByID(id);
            result = true;
        }
        return result;
    }

}

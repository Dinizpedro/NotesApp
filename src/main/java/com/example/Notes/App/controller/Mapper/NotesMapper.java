package com.example.Notes.App.controller.Mapper;

import com.example.Notes.App.domain.Notes;
import com.example.Notes.App.dtos.NotesDTO;
import org.springframework.stereotype.Service;

@Service
public class NotesMapper {
    public NotesDTO toDTO(Notes note) {
        return new NotesDTO(note.getId(), note.getName(), note.getDescription(), note.getCreationDate());
    }
}

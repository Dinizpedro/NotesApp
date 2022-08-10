package com.example.Notes.App.repository.assembler;

import com.example.Notes.App.domain.Notes;
import com.example.Notes.App.repository.data.NotesJPA;
import org.springframework.stereotype.Service;

@Service
public class NoteAssembler {

    public Notes toDomain (NotesJPA notes) {
        return new Notes(notes.getId(), notes.getName(),notes.getDescription(),notes.getCreationDate());
    }
    public NotesJPA toJPA (Notes notes) {
        return new NotesJPA(notes.getName(),notes.getDescription());
    }
}

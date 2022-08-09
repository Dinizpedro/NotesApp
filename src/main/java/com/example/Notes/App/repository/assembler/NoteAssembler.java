package com.example.Notes.App.repository.assembler;

import com.example.Notes.App.domain.Notes;
import com.example.Notes.App.repository.data.NotesJPA;

public class NoteAssembler {

    public Notes toDomain (NotesJPA notes) {
        return new Notes(notes.getName(),notes.getDescription());
    }
    public NotesJPA toJPA (Notes notes) {
        return new NotesJPA(notes.getName(),notes.getDescription());
    }
}

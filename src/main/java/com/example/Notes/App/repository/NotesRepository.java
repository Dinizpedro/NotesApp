package com.example.Notes.App.repository;


import com.example.Notes.App.repository.assembler.NoteAssembler;
import com.example.Notes.App.repository.interfaces.iNotes;
import org.springframework.beans.factory.annotation.Autowired;

public class NotesRepository {

    @Autowired
    NoteAssembler assembler;

    @Autowired
    iNotes iNotes;

    @Autowired
    public NotesRepository(NoteAssembler assembler, com.example.Notes.App.repository.interfaces.iNotes iNotes) {
        this.assembler = assembler;
        this.iNotes = iNotes;
    }

    public void createNotes(String name, String description) {



    }

}

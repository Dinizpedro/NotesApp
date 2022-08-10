package com.example.Notes.App.repository;


import com.example.Notes.App.domain.Notes;
import com.example.Notes.App.repository.assembler.NoteAssembler;
import com.example.Notes.App.repository.data.NotesJPA;
import com.example.Notes.App.repository.interfaces.iNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
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

    public void saveNotes(Notes notes) {
            NotesJPA notesJPA = assembler.toJPA(notes);
            iNotes.save(notesJPA);
    }

}

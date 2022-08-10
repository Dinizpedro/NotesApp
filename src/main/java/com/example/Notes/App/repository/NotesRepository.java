package com.example.Notes.App.repository;


import com.example.Notes.App.domain.Notes;
import com.example.Notes.App.repository.assembler.NoteAssembler;
import com.example.Notes.App.repository.data.NotesJPA;
import com.example.Notes.App.repository.interfaces.iNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    public List<Notes> findAllNotes() {
        List<Notes> notes = new ArrayList<>();
        List<NotesJPA> notesJPA = iNotes.findAll(Sort.by(Sort.Direction.DESC,"Id"));

        for(NotesJPA noteJPA : notesJPA) {
            Notes note = assembler.toDomain(noteJPA);
            notes.add(note);
        }
        return notes;
    }

    public void deleteByID(Long id) {
        iNotes.deleteById(id);
    }

    public boolean existsById(Long id) {
        return iNotes.existsById(id);
    }

}

package com.example.Notes.App.repository.interfaces;

import com.example.Notes.App.repository.data.NotesJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iNotes extends JpaRepository<NotesJPA,Long> {
    
}

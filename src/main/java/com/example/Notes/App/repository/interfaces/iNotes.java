package com.example.Notes.App.repository.interfaces;

import com.example.Notes.App.repository.data.NotesJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface iNotes extends JpaRepository<NotesJPA,Long> {
    @Override
    <S extends NotesJPA> S save(S entity);

     List<NotesJPA> findAll();
}

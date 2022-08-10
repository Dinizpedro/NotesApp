package com.example.Notes.App.repository.interfaces;

import com.example.Notes.App.repository.data.NotesJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface iNotes extends JpaRepository<NotesJPA,Long> {
    @Override
    <S extends NotesJPA> S save(S entity);

     List<NotesJPA> findAll();

    void deleteById(Long id);

     boolean existsById(Long id);

     Optional<NotesJPA> findById(Long id);
}

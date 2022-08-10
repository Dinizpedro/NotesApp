package com.example.Notes.App.controller;

import com.example.Notes.App.dtos.CreateNoteDTO;
import com.example.Notes.App.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {
    @Autowired
    NotesService service;

    @Autowired
    public NotesController(NotesService service) {
        this.service = service;
    }

    @PostMapping("/notes")
    public ResponseEntity<Object> createNote(@RequestBody CreateNoteDTO dto) {
        if(service.createNotes(dto.getName(),dto.getDescription())) {
            return new ResponseEntity<>("Notes created with success.", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Operation failed.", HttpStatus.BAD_REQUEST);
        }
    }

}

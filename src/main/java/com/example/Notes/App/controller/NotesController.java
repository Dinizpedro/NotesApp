package com.example.Notes.App.controller;

import com.example.Notes.App.dtos.CreateNoteDTO;
import com.example.Notes.App.dtos.DeleteNoteDTO;
import com.example.Notes.App.dtos.UpdateNoteDTO;
import com.example.Notes.App.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
        if (service.createNotes(dto.getName(), dto.getDescription())) {
            return new ResponseEntity<>("Notes created with success.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Operation failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/notes")
    @ResponseBody
    public ResponseEntity<Object> getNotes() {
        return new ResponseEntity<>(service.findAllNotes(), HttpStatus.OK);
    }

    @DeleteMapping("/notes")
    public ResponseEntity<Object> deleteNotes(@RequestBody DeleteNoteDTO dto) {
        if (service.deleteById(dto.getId())) {
            return new ResponseEntity<>("Notes succesfully deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Operation Failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/notes")
    public ResponseEntity<Object> updateNotes(@RequestBody UpdateNoteDTO dto) {
        if (service.updateNote(dto.getId(), dto.getName(), dto.getDescription())) {
            return new ResponseEntity<>("Notes succesfully updated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Operation Failed.", HttpStatus.BAD_REQUEST);
        }
    }
}

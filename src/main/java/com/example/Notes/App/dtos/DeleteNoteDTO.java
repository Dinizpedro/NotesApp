package com.example.Notes.App.dtos;

public class DeleteNoteDTO {
    private Long id;

    public DeleteNoteDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

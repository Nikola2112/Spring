package com.goit.Spring.Boot.controllers;
import com.goit.Spring.Boot.services.NoteService;
import com.goit.Spring.Boot.entities.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
/*
@RestController
@RequestMapping("/note")
public class NoteControllerJSON {

    private final NoteService noteService;

    @Autowired
    public NoteControllerJSON(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping()
    public List<Note> listNotes() {
        return noteService.listAll();
    }

    @PostMapping("/create")
    public Note createNote(@RequestBody Note newNote) {
        return noteService.creatNote(newNote);
    }

    @GetMapping("/edit")
    public Optional<Note> editNote(@RequestParam("id") long id) {
        return noteService.getById(id);
    }

    @PutMapping("/edit")
    public Note updateNote(@RequestBody Note note) {
        return noteService.update(note);
    }

    @DeleteMapping("/delete")
    public void deleteNote(@RequestParam("id") long id) {
        noteService.deleteById(id);
    }
} */
package com.goit.Spring.Boot.controllers;

/*
import com.goit.Spring.Boot.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import com.goit.Spring.Boot.entities.Note;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/create")
    public String createNote() {
        return "creating-new-node-page";
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNote(@RequestBody Note newNote) {
        noteService.createNote(newNote);
        return ResponseEntity.status(HttpStatus.CREATED).body("Note created successfully");
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Note> editNote(@PathVariable("id") long id) {
        Optional<Note> note = noteService.getById(id);
        return note.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateNote(@PathVariable("id") long id, @RequestBody Note note) {
        if (!noteService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        note.setId(id);
        noteService.update(note);
        return ResponseEntity.ok("Note updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable("id") Long id) {
        if (!noteService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        noteService.deleteById(id);
        return ResponseEntity.ok("Note deleted successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Note>> searchNotes(@RequestParam(value = "keyword", required = false) String keyword) {
        List<Note> notes = (keyword != null && !keyword.isEmpty()) ? noteService.searchNotes(keyword) : noteService.listAll();
        return ResponseEntity.ok(notes);
    }
}
 */
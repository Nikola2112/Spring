package com.goit.Spring.Boot.controllers;

import com.goit.Spring.Boot.services.NoteService;
import org.springframework.ui.Model;
import com.goit.Spring.Boot.entities.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import com.goit.Spring.Boot.trash.NoteService1;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping()
    public String listNotes(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute("note",  notes);
        model.addAttribute("newNote", new Note());
        return "notes/note";
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute Note newNote) {
       noteService.creatNote(newNote);
        return "redirect:/note";
    }

    @GetMapping("/edit")
    public String editNote(@RequestParam("id") long id, Model model) {
        Optional<Note> note = noteService.getById(id);
        model.addAttribute("note", note);
        return "notes/edit";
    }

    @PostMapping("/edit")
    public String updateNote(@ModelAttribute("note") Note note) {
        noteService.update(note);
        return "redirect:/note";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note";
    }
}




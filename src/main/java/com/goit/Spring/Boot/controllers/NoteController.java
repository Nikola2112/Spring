package com.goit.Spring.Boot.controllers;


import com.goit.Spring.Boot.services.NoteService;
import org.springframework.ui.Model;
import com.goit.Spring.Boot.entities.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/list")
    public String listNotes(Model model) {
        List<Note> note = noteService.listAll();
        model.addAttribute("note",  note);
        model.addAttribute("newNote", new Note());
        return "main-page";//notes/note
    }
    @GetMapping("/create")
    public String createNote() {
        return "creating-new-node-page";
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute Note newNote) {
       noteService.creatNote(newNote);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNote(@RequestParam("id") long id, Model model) {
        Optional<Note> note = noteService.getById(id);
        model.addAttribute("note", note);
        return "edit-page";
    }

    @PostMapping("/edit")
    public String updateNote(@ModelAttribute("note") Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}



package com.goit.Spring.Boot.controllers;


import com.goit.Spring.Boot.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import com.goit.Spring.Boot.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


// контроллер  для додатка

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;


    @GetMapping("/create")
    public String createNote() {
        return "creating-new-node-page";
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute Note newNote) {
       noteService.createNote(newNote);
        return "redirect:/note/search";
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
        return "redirect:/note/search";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/search";
    }
    @GetMapping("/search")
    public String searchNotes(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Note> notes = (keyword != null && !keyword.isEmpty()) ? noteService.searchNotes(keyword) : noteService.listAll();
        model.addAttribute("note", notes);
        return "main-page";
       }
    }



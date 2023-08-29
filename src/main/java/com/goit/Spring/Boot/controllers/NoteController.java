package com.goit.Spring.Boot.controllers;

import org.springframework.ui.Model;
import com.goit.Spring.Boot.entities.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.goit.Spring.Boot.services.NoteService;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller()
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;
   @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }
    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("note", noteService.listAll());
        return "note/list";
    }
    @PostMapping("/delete")
    public String deleteNote(@RequestParam Long id, Model model) {
        noteService.deleteById(id);
        return "redirect:/note/list";
       // public RedirectView deleteNote(@PathVariable ("id") Long id,@RequestParam Model model)
        // return new RedirectView("/note/list");
    }
    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable ("id") Long id,@RequestParam Model model){
       noteService.getById(id);

       return "note/editNote";
    }
    @PostMapping("/edit/note")
    public String saveEditNote(@RequestParam Long id ,Note editNote){
       noteService.update(editNote);

       return "redirect: /note/list";
    }
}


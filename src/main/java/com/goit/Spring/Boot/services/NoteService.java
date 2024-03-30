package com.goit.Spring.Boot.services;

import com.goit.Spring.Boot.model.Note;


import java.util.List;
import java.util.Optional;

// класс визначає які методи буть в сервсі *(поліморфізм)
public interface NoteService {

     List<Note> listAll();

     Note createNote(Note note);

    void deleteById(Long id);
     Optional<Note> getById(Long id);
    Note update(Note note);

    List<Note> searchNotes(String keyword);
}

package com.goit.Spring.Boot.services.impl;

import com.goit.Spring.Boot.entities.Note;

import java.util.List;

public interface NoteServiceImpl {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id);
    void update(Note note);
    Note getById(long id);
}

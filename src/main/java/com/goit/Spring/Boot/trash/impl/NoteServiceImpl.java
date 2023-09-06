package com.goit.Spring.Boot.trash.impl;

import com.goit.Spring.Boot.entities.Note;

import java.util.List;

public interface NoteServiceImpl {
    List<Note> listAll();
    Note createNote(Note note);
    void deleteById(long id);
    void update(Note note);
    Note getById(long id);
}

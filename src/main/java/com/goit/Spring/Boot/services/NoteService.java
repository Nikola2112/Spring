package com.goit.Spring.Boot.services;

import com.goit.Spring.Boot.entities.Note;
import com.goit.Spring.Boot.services.impl.NoteServiceImpl;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class NoteService implements NoteServiceImpl {
    private final List<Note> noteList = new LinkedList<>();
    private Long nextId = 1L;

    @Override
    public List<Note> listAll() {
        return noteList;
    }

    @Override
    public Note add(Note note) {
        note.getId(nextId);
        nextId++;
        noteList.add(note);
        return note;

    }

    @Override
    public void deleteById(long id) {
        noteList.removeIf(note -> note.getId() == id);
    }

    @Override
    public void update(Note note) {
        for (int i = 0; i < noteList.size(); i++) {
            if (noteList.get(i).getId().equals(note.getId())) {
                noteList.set(i, note);
                return;
            }
        }
    }

    @Override
    public Note getById(long id) {
        for (Note note : noteList) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }
     }
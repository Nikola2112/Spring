package com.goit.Spring.Boot.trash;

import com.goit.Spring.Boot.entities.Note;
import com.goit.Spring.Boot.trash.impl.NoteServiceImpl;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class NoteService1 implements NoteServiceImpl {



    private final List<Note> noteList = new LinkedList<>();
    private Long nextId = 1L;

    @Override
    public List<Note> listAll() {
        return noteList;
    }

    @Override
    public Note createNote(Note note) {
        note.setId(nextId);
        nextId++;
        noteList.add(note);
        return note;

    }

    @Override
    public void deleteById(long id) {
        noteList.removeIf(note -> note.getId().equals(id));
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
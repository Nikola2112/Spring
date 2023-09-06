package com.goit.Spring.Boot.services;

import com.goit.Spring.Boot.entities.Note;
import com.goit.Spring.Boot.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NoteService {
    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public List<Note> listAll(){
        return (List<Note>) repository.findAll();
    }

    public Note creatNote(Note note){
        return  repository.save(note);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public Optional<Note> getById(Long id){
        return repository.findById(id);
    }
    public Note update(Note note){
        return repository.save(note);
    }


}

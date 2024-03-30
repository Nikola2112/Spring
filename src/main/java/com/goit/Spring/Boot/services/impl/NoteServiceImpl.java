package com.goit.Spring.Boot.services.impl;

import com.goit.Spring.Boot.entities.Note;
import com.goit.Spring.Boot.repository.NoteRepository;
import com.goit.Spring.Boot.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository repository;


    public List<Note> listAll(){
        return (List<Note>) repository.findAll();
    }
    public Note createNote(Note note){
        return  repository.save(note);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    public Optional<Note> getById(Long id){ return repository.findById(id);}
    public Note update(Note note){
        return repository.save(note);
    }

    @Override
    public List<Note> searchNotes(String keyword) {
        List<Note> allNotes = repository.findAll();

        // ищем заметки , которые имеют ключевое слово
        return allNotes.stream()
                .filter(note -> {
                    String title = note.getTitle();
                    String content = note.getContent();
                    return (title != null && title.toLowerCase().contains(keyword.toLowerCase())) ||
                            (content != null && content.toLowerCase().contains(keyword.toLowerCase()));
                })
                .collect(Collectors.toList());
//        return allNotes.stream()
//                .filter(note -> note.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
//                        note.getContent().toLowerCase().contains(keyword.toLowerCase()))
//                .collect(Collectors.toList());
    }

}

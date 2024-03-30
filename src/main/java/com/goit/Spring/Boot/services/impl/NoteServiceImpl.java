package com.goit.Spring.Boot.services.impl;

import com.goit.Spring.Boot.model.Note;
import com.goit.Spring.Boot.repository.NoteRepository;
import com.goit.Spring.Boot.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//класс реалізує інтерфейс , містить логіку оброботки операцій нотаток
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

        // шукаєм нотатки  , які мають ключове слово(без різниці на написання з великої чи маленької букви)
        // також можливий пошук по букві(якщо буква є в нотатці то пошук покаже її)
        return allNotes.stream()
                .filter(note -> {
                    String title = note.getTitle();
                    String content = note.getContent();
                    return (title != null && title.toLowerCase().contains(keyword.toLowerCase())) ||
                            (content != null && content.toLowerCase().contains(keyword.toLowerCase()));
                })
                .collect(Collectors.toList());
    }

}

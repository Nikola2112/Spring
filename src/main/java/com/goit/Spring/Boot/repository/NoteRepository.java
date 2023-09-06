package com.goit.Spring.Boot.repository;

import com.goit.Spring.Boot.entities.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends CrudRepository<Note,Long>{

    List<Note> findAll();
    Note save(Note note);
    void deleteById(Long id);
    Optional<Note> findById(Long id);
}

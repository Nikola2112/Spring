package com.goit.Spring.Boot.repository;

import com.goit.Spring.Boot.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//класс взаємодії з БД
@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
}

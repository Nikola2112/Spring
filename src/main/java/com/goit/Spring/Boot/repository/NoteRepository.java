package com.goit.Spring.Boot.repository;

import com.goit.Spring.Boot.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
}

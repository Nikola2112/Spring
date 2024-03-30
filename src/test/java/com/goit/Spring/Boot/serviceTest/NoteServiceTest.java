package com.goit.Spring.Boot.serviceTest;
import com.goit.Spring.Boot.entities.Note;
import com.goit.Spring.Boot.repository.NoteRepository;
import com.goit.Spring.Boot.services.NoteService;
import com.goit.Spring.Boot.services.impl.NoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class NoteServiceTest {

    @Test
    public void testListAll() {
        NoteRepository repository = Mockito.mock(NoteRepository.class);
        NoteService noteService = new NoteServiceImpl(repository);
        List<Note> expectedNotes = new ArrayList<>();
        expectedNotes.add(new Note());
        expectedNotes.add(new Note());
        when(repository.findAll()).thenReturn(expectedNotes);

        List<Note> actualNotes = noteService.listAll();

        assertEquals(expectedNotes.size(), actualNotes.size());
    }

    @Test
    public void testCreateNote() {
        NoteRepository repository = Mockito.mock(NoteRepository.class);
        NoteService noteService = new NoteServiceImpl(repository);
        Note note = new Note();
        when(repository.save(any())).thenReturn(note);

        Note savedNote = noteService.createNote(new Note());

        assertEquals(note, savedNote);
    }

    @Test
    public void testDeleteById() {
        NoteRepository repository = Mockito.mock(NoteRepository.class);
        NoteService noteService = new NoteServiceImpl(repository);
        Long id = 1L;
        doNothing().when(repository).deleteById(id);

        noteService.deleteById(id);

        verify(repository, times(1)).deleteById(id);
    }

    @Test
    public void testGetById() {
        NoteRepository repository = Mockito.mock(NoteRepository.class);
        NoteService noteService = new NoteServiceImpl(repository);
        Long id = 1L;
        Note expectedNote = new Note();
        when(repository.findById(id)).thenReturn(Optional.of(expectedNote));

        Optional<Note> actualNote = noteService.getById(id);

        assertTrue(actualNote.isPresent());
        assertEquals(expectedNote, actualNote.get());
    }

    @Test
    public void testUpdate() {
        NoteRepository repository = Mockito.mock(NoteRepository.class);
        NoteService noteService = new NoteServiceImpl(repository);
        Note note = new Note();
        when(repository.save(any())).thenReturn(note);

        Note updatedNote = noteService.update(note);

        assertEquals(note, updatedNote);
    }
}


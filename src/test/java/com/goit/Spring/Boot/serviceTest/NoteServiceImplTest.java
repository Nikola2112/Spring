package com.goit.Spring.Boot.serviceTest;
import com.goit.Spring.Boot.model.Note;
import com.goit.Spring.Boot.repository.NoteRepository;
import com.goit.Spring.Boot.services.impl.NoteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class NoteServiceImplTest {

    @Mock
    private NoteRepository repository;

    @InjectMocks
    private NoteServiceImpl noteService;

    // Ініціалізуємо  мок
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testListAll() {
        Note note1 = new Note();
        note1.setId(1L);
        note1.setTitle("Title 1");
        note1.setContent("Content 1");

        Note note2 = new Note();
        note2.setId(2L);
        note2.setTitle("Title 2");
        note2.setContent("Content 2");

        List<Note> mockNotes = Arrays.asList(note1, note2);

        when(repository.findAll()).thenReturn(mockNotes);

        List<Note> result = noteService.listAll();
        assertEquals(2, result.size());
        assertEquals("Title 1", result.get(0).getTitle());
        assertEquals("Title 2", result.get(1).getTitle());
    }

    @Test
    public void testCreateNote() {
        Note note = new Note();
        note.setId(1L);
        note.setTitle("Title");
        note.setContent("Content");

        when(repository.save(any(Note.class))).thenReturn(note);

        Note savedNote = noteService.createNote(note);
        assertEquals("Title", savedNote.getTitle());
        assertEquals("Content", savedNote.getContent());
    }

    @Test
    public void testDeleteById() {
        doNothing().when(repository).deleteById(1L);
        noteService.deleteById(1L);
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetById() {
        Note note = new Note();
        note.setId(1L);
        note.setTitle("Title");
        note.setContent("Content");

        when(repository.findById(1L)).thenReturn(Optional.of(note));

        Optional<Note> result = noteService.getById(1L);
        assertTrue(result.isPresent());
        assertEquals("Title", result.get().getTitle());
        assertEquals("Content", result.get().getContent());
    }

    @Test
    public void testUpdate() {
        Note note = new Note();
        note.setId(1L);
        note.setTitle("Title");
        note.setContent("Content");

        when(repository.save(any(Note.class))).thenReturn(note);

        Note updatedNote = noteService.update(note);
        assertEquals("Title", updatedNote.getTitle());
        assertEquals("Content", updatedNote.getContent());
    }

    @Test
    public void testSearchNotes() {
        Note note1 = new Note();
        note1.setId(1L);
        note1.setTitle("Title 1");
        note1.setContent("Content 1");

        Note note2 = new Note();
        note2.setId(2L);
        note2.setTitle("Title 2");
        note2.setContent("Content 2");

        List<Note> mockNotes = Arrays.asList(note1, note2);

        when(repository.findAll()).thenReturn(mockNotes);

        List<Note> result = noteService.searchNotes("Title");
        assertEquals(2, result.size());
        assertEquals("Title 1", result.get(0).getTitle());
        assertEquals("Title 2", result.get(1).getTitle());
    }
}

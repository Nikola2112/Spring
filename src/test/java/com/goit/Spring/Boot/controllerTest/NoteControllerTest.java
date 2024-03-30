package com.goit.Spring.Boot.controllerTest;
import com.goit.Spring.Boot.controllers.NoteController;
import com.goit.Spring.Boot.model.Note;
import com.goit.Spring.Boot.services.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NoteControllerTest {

    @Mock
    private NoteService noteService;

    @InjectMocks
    private NoteController noteController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this); // инициализируем моки
    }

    @Test
    public void testCreateNote() {
        String viewName = noteController.createNote();
        assertEquals("creating-new-node-page", viewName);
    }

    @Test
    public void testCreateNotePost() {
        Note newNote = new Note();
        String redirectUrl = noteController.createNote(newNote);
        assertEquals("redirect:/note/search", redirectUrl);
        verify(noteService, times(1)).createNote(newNote);
    }

    @Test
    public void testEditNote() {
        long id = 1L;
        Model model = mock(Model.class);
        Note note = new Note();
        when(noteService.getById(id)).thenReturn(Optional.of(note));
        // Ініціалізуєм мок
        MockitoAnnotations.openMocks(this);
        //  запускаємо тест
        String viewName = noteController.editNote(id, model);
        assertEquals("edit-page", viewName);
        verify(model, times(1)).addAttribute(eq("note"), any());
    }


    @Test
    public void testUpdateNote() {
        Note note = new Note();
        String redirectUrl = noteController.updateNote(note);
        assertEquals("redirect:/note/search", redirectUrl);
        verify(noteService, times(1)).update(note);
    }

    @Test
    public void testDeleteNote() {
        Long id = 1L;
        String redirectUrl = noteController.deleteNote(id);
        assertEquals("redirect:/note/search", redirectUrl);
        verify(noteService, times(1)).deleteById(id);
    }

    @Test
    public void testSearchNotes() {
        String keyword = "test";
        Model model = mock(Model.class);
        when(noteService.searchNotes(keyword)).thenReturn(Arrays.asList(new Note())); // assuming Note is your model class
        String viewName = noteController.searchNotes(keyword, model);
        assertEquals("main-page", viewName);
        verify(model, times(1)).addAttribute(eq("note"), any());
    }
}

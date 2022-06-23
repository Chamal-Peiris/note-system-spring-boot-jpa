package lk.ijse.dep.note.service.impl;

import lk.ijse.dep.note.dto.NoteDTO;
import lk.ijse.dep.note.repository.custom.NoteRepository;
import lk.ijse.dep.note.service.Noteservice;
import lk.ijse.dep.note.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoteServiceImpl implements Noteservice {

    @Autowired
    private NoteRepository noteRepository;
    @Override
    public NoteDTO saveNote(NoteDTO note) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteNote(String userId, int noteId) throws NotFoundException {

    }

    @Override
    public List<NoteDTO> getAllNotes(String userId) {
        return null;
    }
}

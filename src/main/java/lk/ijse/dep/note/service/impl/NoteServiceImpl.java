package lk.ijse.dep.note.service.impl;

import lk.ijse.dep.note.dto.NoteDTO;
import lk.ijse.dep.note.entity.Note;
import lk.ijse.dep.note.entity.User;
import lk.ijse.dep.note.repository.custom.NoteRepository;
import lk.ijse.dep.note.repository.custom.UserRepository;
import lk.ijse.dep.note.service.Noteservice;
import lk.ijse.dep.note.service.exception.NotFoundException;
import lk.ijse.dep.note.service.exception.UnauthorizedAccessException;
import lk.ijse.dep.note.service.util.EntityDTOConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class NoteServiceImpl implements Noteservice {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private EntityDTOConverter converter;
    @Autowired
    private UserRepository userRepository;
    @Override
    public NoteDTO saveNote(NoteDTO note) throws NotFoundException {

        Note noteEntity = converter.getNoteEntity(note);
        noteEntity.setUser(getUser(note.getUserId()));
        return converter.getNoteDTO(noteRepository.save(noteEntity));

    }

    @Override
    public void deleteNote(String userId, int noteId) throws NotFoundException {

        Optional<Note> opNote = noteRepository.findById(noteId);
        if(!opNote.isPresent()) throw  new NotFoundException("Invalid Note id");
        if(getUser(userId)!=opNote.get().getUser()) throw  new UnauthorizedAccessException("User is not authorized to delete this note");
        noteRepository.deleteById(noteId);


    }

    @Override
    public List<NoteDTO> getAllNotes(String userId) {

       return noteRepository.findAllNotesByUser(getUser(userId)).stream().map(converter::getNoteDTO).collect(Collectors.toList());
    }

    private User getUser(String userId){
        Optional<User> optUser = userRepository.findById(userId);
        if(!optUser.isPresent()) throw new NotFoundException("User Doesnt exist");
        return optUser.get();
    }
}

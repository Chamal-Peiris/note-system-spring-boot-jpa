package lk.ijse.dep.note.service;

import lk.ijse.dep.note.dto.NoteDTO;
import lk.ijse.dep.note.service.exception.NotFoundException;
import java.util.List;
public interface Noteservice {

   NoteDTO saveNote(NoteDTO note) throws NotFoundException;

   void deleteNote(String userId,int noteId) throws NotFoundException;

   List<NoteDTO> getAllNotes(String userId);
}

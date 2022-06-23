package lk.ijse.dep.note.repository.custom;

import lk.ijse.dep.note.entity.Note;
import lk.ijse.dep.note.entity.User;
import lk.ijse.dep.note.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note,Integer> {


    List<Note> findAllNotesByUser(User user);
}

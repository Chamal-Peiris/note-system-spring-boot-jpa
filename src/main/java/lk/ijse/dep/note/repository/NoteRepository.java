package lk.ijse.dep.note.repository;

import lk.ijse.dep.note.entity.Note;
import lk.ijse.dep.note.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note,Integer> {


    List<Note> findAllNotesByUser(User user);
    long countNotesByUser(User user);

}

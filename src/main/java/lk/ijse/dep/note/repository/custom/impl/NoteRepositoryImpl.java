package lk.ijse.dep.note.repository.custom.impl;

import lk.ijse.dep.note.entity.Note;
import lk.ijse.dep.note.entity.User;
import lk.ijse.dep.note.repository.CrudRepositoryImpl;
import lk.ijse.dep.note.repository.custom.NoteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteRepositoryImpl extends CrudRepositoryImpl<Note,Integer> implements NoteRepository {
    @Override
    public List<Note> findAllNotesByUser(User user) {
      return  entityManager.createQuery("SELECT n FROM Note n WHERE n.user=:user",Note.class).setParameter("user",user).getResultList();
    }
}

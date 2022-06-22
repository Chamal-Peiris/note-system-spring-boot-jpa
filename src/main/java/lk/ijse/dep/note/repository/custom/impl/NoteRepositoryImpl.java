package lk.ijse.dep.note.repository.custom.impl;

import lk.ijse.dep.note.entity.Note;
import lk.ijse.dep.note.repository.CrudRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class NoteRepositoryImpl extends CrudRepositoryImpl<Note,String> {
}

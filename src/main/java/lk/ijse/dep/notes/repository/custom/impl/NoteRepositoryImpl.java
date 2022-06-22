package lk.ijse.dep.notes.repository.custom.impl;

import lk.ijse.dep.notes.entity.Note;
import lk.ijse.dep.notes.repository.CrudRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class NoteRepositoryImpl extends CrudRepositoryImpl<Note,String> {
}

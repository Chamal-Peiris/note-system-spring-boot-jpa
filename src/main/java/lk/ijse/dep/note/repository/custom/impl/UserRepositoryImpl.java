package lk.ijse.dep.note.repository.custom.impl;

import lk.ijse.dep.note.entity.User;
import lk.ijse.dep.note.repository.CrudRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends CrudRepositoryImpl<User,String> {
}

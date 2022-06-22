package lk.ijse.dep.notes.repository.custom.impl;

import lk.ijse.dep.notes.entity.User;
import lk.ijse.dep.notes.repository.CrudRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends CrudRepositoryImpl<User,String> {
}

package lk.ijse.dep.note.repository.custom;

import lk.ijse.dep.note.entity.User;
import lk.ijse.dep.note.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<User,String> {
}

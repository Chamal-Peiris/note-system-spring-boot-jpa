package lk.ijse.dep.note.repository.custom;

import lk.ijse.dep.note.entity.User;


public interface UserRepository extends CrudRepository<User,String> {
    boolean existUserByEmail(String email);
}

package lk.ijse.dep.note.repository;

import lk.ijse.dep.note.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,String> {
    boolean existsUserByEmail(String email);

    List<User> getUsersByFullNameLike(String query);
}

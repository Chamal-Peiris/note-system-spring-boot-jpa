package lk.ijse.dep.note.repository.custom.impl;

import lk.ijse.dep.note.entity.User;
import lk.ijse.dep.note.repository.CrudRepositoryImpl;
import lk.ijse.dep.note.repository.custom.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends CrudRepositoryImpl<User,String> implements UserRepository {
    @Override
    public boolean existUserByEmail(String email) {
       return !entityManager.createQuery("SELECT u FROM lk.ijse.dep.note.entity.User u WHERE u.email= :email").setParameter("email",email).getResultList().isEmpty();
    }
}

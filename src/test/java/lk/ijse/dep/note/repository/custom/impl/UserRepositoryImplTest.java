package lk.ijse.dep.note.repository.custom.impl;

import lk.ijse.dep.note.config.WebAppConfig;
import lk.ijse.dep.note.config.WebRootConfig;
import lk.ijse.dep.note.entity.User;
import lk.ijse.dep.note.repository.custom.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringJUnitConfig({WebRootConfig.class, WebAppConfig.class})
class UserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
        //given
        User user = new User("U001", "chamal.peiris3g@gmail.com", "123456", "chamal peiris");
        //when
        User savedUser = userRepository.save(user);
        //then
        assertEquals(user, savedUser);
    }

    @Test
    void deleteById() {
        //given
        User user = new User("U001", "uppa@gmail.com", "uppa123", "thilina upendra");
        userRepository.save(user);
        //when
        userRepository.deleteById(user.getId());

        //then
        assertFalse(userRepository.existById(user.getId()));

    }

    @Test
    void existsById() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void count() {
    }
}
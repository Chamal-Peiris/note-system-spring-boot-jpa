package lk.ijse.dep.note.service.impl;

import lk.ijse.dep.note.dto.UserDTO;
import lk.ijse.dep.note.repository.custom.UserRepository;
import lk.ijse.dep.note.service.UserService;
import lk.ijse.dep.note.service.exception.DuplicateEmailException;
import lk.ijse.dep.note.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserDTO registerUser(UserDTO user) throws DuplicateEmailException {
        if(userRepository.existUserByEmail(user.getEmail()) ) throw new DuplicateEmailException("Email already exists");
        return userRepository
    }

    @Override
    public void updateUser(UserDTO user) throws NotFoundException {

    }

    @Override
    public UserDTO getUserInfo(String userId) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteUser(String userId) throws NotFoundException {

    }
}

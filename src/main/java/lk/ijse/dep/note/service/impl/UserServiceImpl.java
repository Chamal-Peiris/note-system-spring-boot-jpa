package lk.ijse.dep.note.service.impl;

import lk.ijse.dep.note.dto.UserDTO;
import lk.ijse.dep.note.entity.User;
import lk.ijse.dep.note.repository.custom.UserRepository;
import lk.ijse.dep.note.service.UserService;
import lk.ijse.dep.note.service.exception.DuplicateEmailException;
import lk.ijse.dep.note.service.exception.NotFoundException;
import lk.ijse.dep.note.service.util.EntityDTOConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private EntityDTOConverter transformer;


    @Override
    public UserDTO registerUser(UserDTO user) throws DuplicateEmailException {
        if(userRepository.existUserByEmail(user.getEmail()) ) throw new DuplicateEmailException("Email already exists");
        return transformer.getUserDTO(userRepository.save(transformer.getUserEntity(user)));
    }

    @Override
    public void updateUser(UserDTO user) throws NotFoundException {
        Optional<User> optUser = userRepository.findById(user.getId());
        if(!optUser.isPresent()) throw new NotFoundException("invalid user id");
        optUser.get().setFullName(user.getFullName());
        optUser.get().setPassword(user.getPassword());

    }

    @Override
    public UserDTO getUserInfo(String userId) throws NotFoundException {
       return userRepository.findById(userId).map(transformer::getUserDTO).orElseThrow(()->new NotFoundException("Invalid user Id"));

    }

    @Override
    public void deleteUser(String userId) throws NotFoundException {
        if(!userRepository.existById(userId)) throw new NotFoundException("Invalid User id");


    }
}

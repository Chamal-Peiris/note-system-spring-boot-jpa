package lk.ijse.dep.note.service;

import lk.ijse.dep.note.dto.UserDTO;
import lk.ijse.dep.note.service.exception.DuplicateEmailException;
import lk.ijse.dep.note.service.exception.NotFoundException;

public interface UserService {

   UserDTO registerUser(UserDTO user) throws DuplicateEmailException;
   void updateUser(UserDTO user) throws NotFoundException;
   UserDTO getUserInfo(String userId) throws NotFoundException;
   void deleteUser(String userId) throws NotFoundException;

}

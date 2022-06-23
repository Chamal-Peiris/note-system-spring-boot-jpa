package lk.ijse.dep.note.api;

import lk.ijse.dep.note.dto.UserDTO;
import lk.ijse.dep.note.service.UserService;
import lk.ijse.dep.note.service.exception.DuplicateEmailException;
import lk.ijse.dep.note.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    public UserDTO registerUser(@RequestBody UserDTO user){
        //validate


        try {
            userService.registerUser(user);
        } catch (DuplicateEmailException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists",e);
        }
        return user;
    }
    @GetMapping(path = "{userId:[A-Fa-f0-\\~]{36}}}",produces = "application/json")
    public UserDTO getUserInfo(@PathVariable String userId){
        System.out.println("get"+userId);
        try {
            return userService.getUserInfo(userId);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(404,"invalid user id",e);
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{userId:[A-Fa-f0-\\~]{36}}")
    public void deleteuser(@PathVariable String userId){
        try {
            userService.deleteUser(userId);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(404,"invalid user id",e);
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "{userId:[A-Fa-f0-\\~]{36}}",consumes = "application/json")
    public void updateUser(@PathVariable String userId,@RequestBody UserDTO user){
        try {
            userService.updateUser(user);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(404,"invalid user id",e);
        }
    }

}

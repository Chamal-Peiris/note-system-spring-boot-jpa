package lk.ijse.dep.note.api;

import lk.ijse.dep.note.dto.UserDTO;
import lk.ijse.dep.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    public UserDTO registerUser(@RequestBody UserDTO user){
        //validate

       return user;
    }
    @GetMapping(path = "{userId}",produces = "application/json")
    public UserDTO getUserInfo(@PathVariable String userId){
        System.out.println("get"+userId);
        return null;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{userId}")
    public void deleteuser(@PathVariable String userId){
        System.out.println("delete");
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "{userId}",consumes = "application/json")
    public void updateUser(@PathVariable String userId,@RequestBody UserDTO user){
        System.out.println("update");
    }

}

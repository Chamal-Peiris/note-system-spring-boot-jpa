package lk.ijse.dep.note.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    public void registerUser(){
        System.out.println("register");
    }
    @GetMapping(path = "{userId}",produces = "application/json")
    public void getUserInfo(){
        System.out.println("get");
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{userId}")
    public void deleteuser(){
        System.out.println("delete");
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "{userId}",consumes = "application/json")
    public void updateUser(){
        System.out.println("update");
    }

}

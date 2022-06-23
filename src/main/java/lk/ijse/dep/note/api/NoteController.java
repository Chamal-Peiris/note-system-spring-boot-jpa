package lk.ijse.dep.note.api;

import lk.ijse.dep.note.dto.NoteDTO;
import lk.ijse.dep.note.service.Noteservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@RestController
@RequestMapping("api/v1/users/{userId:[A-F0-9\\-]{36}/notes")
public class NoteController {

    @Autowired
    private Noteservice noteservice;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    public NoteDTO addNote(@PathVariable String userId, @RequestBody @Validated NoteDTO noteDTO, Errors errors){
        if(errors.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors.getFieldErrors().get(0).getDefaultMessage());
        }
        if(!userId.equals(noteDTO.getUserId())) throw new ResponseStatusException(HttpStatus.CONFLICT,"User Id mismatch");

        //Todo: save this node
        return noteservice.saveNote(noteDTO);
    }

    @GetMapping(produces = "application/json")
    public List<NoteDTO> getAllNotes(@PathVariable String userId){

       return noteservice.getAllNotes(userId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{noteId:\\d+}")
    public void deleteNote(@PathVariable String userId,@PathVariable  int noteId) {
        noteservice.deleteNote(userId,noteId);
    }
}

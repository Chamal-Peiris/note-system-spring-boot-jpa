package lk.ijse.dep.note.advice;

import lk.ijse.dep.note.service.exception.DuplicateEmailException;
import lk.ijse.dep.note.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateEmailException.class)
    public void handleDuplicateEmailexception(DuplicateEmailException e){
       e.initCause( new ResponseStatusException(HttpStatus.CONFLICT,e.getMessage()));
    }
    @ExceptionHandler(NotFoundException.class)
    public void handleNotfoundExcpetion(NotFoundException e){
        e.initCause(new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage()));
    }
}

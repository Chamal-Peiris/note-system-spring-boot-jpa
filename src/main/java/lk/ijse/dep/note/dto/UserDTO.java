package lk.ijse.dep.note.dto;

import lk.ijse.dep.note.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor @AllArgsConstructor @Data
public class UserDTO implements Serializable {

    private String id;

    private String email;

    private String password;

    private String fullName;
}

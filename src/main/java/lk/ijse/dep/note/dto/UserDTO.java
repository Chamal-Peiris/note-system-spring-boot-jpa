package lk.ijse.dep.note.dto;

import javax.validation.constraints.*;
import lk.ijse.dep.note.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor @AllArgsConstructor @Data
public class UserDTO implements Serializable {

    @Null(message = "Id cannot be set")
    private String id;

    @Email(message = "invalid email")
    @NotNull(message = "email cannot be empty")
    private String email;

    @NotNull(message = "Password cannot be empty")
    @Length(max = 6,message = "Password must have minimum of 6 characters")
    @NotNull(message = "Password cannot be null")
    private String password;


    @Pattern(regexp = "[A-za-z ]+",message = "Invalid Name format")
    private String fullName;
}

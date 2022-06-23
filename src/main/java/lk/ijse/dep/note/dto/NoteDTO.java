package lk.ijse.dep.note.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@NoArgsConstructor @AllArgsConstructor @Data
public class NoteDTO implements Serializable {
    @Null(message = "Id cannot be set")
    private int id;
    @NotBlank(message = "Text cannot be empty")
    private String text;
    @Pattern(regexp = "[A-Fa-F0-9\\-]{36}",message = "Invalid user id")
    private String userId;
}

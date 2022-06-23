package lk.ijse.dep.note.entity;

import jdk.internal.dynalink.linker.LinkerServices;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data

public class User implements SuperEntity {
    @Id
    private String id;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String password;
    @Column(name="full_name",unique = true)
    private String fullName;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "user",cascade = {CascadeType.REMOVE})
    private List<Note>  notes=new ArrayList<>();

    @PrePersist
    private void beforePersist(){
        notes.forEach(note->note.setUser(this));
    }

    public User(String id, String email, String password, String fullName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }
}

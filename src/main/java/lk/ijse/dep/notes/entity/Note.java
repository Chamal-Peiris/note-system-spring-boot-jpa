package lk.ijse.dep.notes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Note implements SuperEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    @Column(nullable = false)
    private String text;
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
    @ManyToOne
    private User user;

    public Note(String text,User user){
        this.text=text;
        this.user=user;
    }
}

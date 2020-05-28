package ru.itis.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "itis_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String born;
    private String about;

    private String hashPassword;
    private LocalDateTime createdAt;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String confirmCode;

    //    @ManyToOne
//    @JoinColumn(name = "img")
//    String img;
//    @OneToOne
//    @JoinColumn(name = "img")
//    FileInfo img;

//    @OneToMany(mappedBy = "user")
//    @Where(clause = "createdAt.getMonth() = LocalDateTime.now().getMonth()")
//    private List<HelpMessage> lastMessages;

}

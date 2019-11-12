package pl.coderslab.spring_boot_project.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
//
@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    private User user;
    @CreationTimestamp
    private LocalDateTime created;
    private String content;
    @ManyToOne
    private Task task;
//    private Review review;


}

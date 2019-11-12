package pl.coderslab.spring_boot_project.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "requests")
@Getter
@Setter
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    private User user;
    @CreationTimestamp
    private LocalDateTime created;
    private String request;
    @ManyToOne
    private Review review;

//    table requests {
//        id int [pk, increment]
//        content varchar
//        reviews_id int [ref:> reviews.id]
//        todo_list_id int [ref:> todo_list.id]
//
//    }
}

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
    @Column(nullable = false)
    private Boolean status = false;


}

package pl.coderslab.spring_boot_project.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    private User user;
    @CreationTimestamp
    private LocalDateTime created;
    @ManyToOne
    private Image image;
    @OneToMany (mappedBy = "review")
    private List<Request> request;
    @ManyToOne
    private Task task;
    private String content;
}

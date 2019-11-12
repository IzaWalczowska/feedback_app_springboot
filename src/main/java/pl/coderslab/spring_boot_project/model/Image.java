package pl.coderslab.spring_boot_project.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "images")
@Getter
@Setter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @ManyToOne
//    private User user;
    @CreationTimestamp
    private LocalDateTime created;
    private String path;
    @ManyToOne
    private Task task;
    @ManyToOne
    private Project project;
//    @OneToOne (mappedBy = "image")
//    private Review review;

}

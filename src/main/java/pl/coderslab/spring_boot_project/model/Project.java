package pl.coderslab.spring_boot_project.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @ManyToOne
//    private User user;
    @CreationTimestamp
    private LocalDateTime created;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @NotNull
    private Date deadline;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @OneToMany(mappedBy = "project")
    private List<Task> tasks;
    @ManyToMany
    @JoinTable(name = "projects_users",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;


}

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
@Table(name = "tasks")
@Getter
@Setter
public class Task {

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
    @ManyToOne
    private Project project;
    @NotNull
    private String name;
    @NotNull
    private String description;
//    @Enumerated(EnumType.STRING)
//    private TaskStatus taskStatus;
    @OneToMany (mappedBy = "task")
    private List<Image> images;
//    @Column(columnDefinition = "varchar 16 default WAITING")
    private String taskStatus = TaskStatus.WAITING.name();


//    table tasks {
//        id int [pk, increment]
//        name varchar
//        description varchar
//        created date
//        deadline date
//        projects_id int  [ref:> projects.id]
//    }

}

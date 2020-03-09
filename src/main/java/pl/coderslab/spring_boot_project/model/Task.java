package pl.coderslab.spring_boot_project.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task implements Comparable<Task>{

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
    @OneToMany (mappedBy = "task")
    private List<Image> images;
    private String taskStatus = TaskStatus.WAITING.name();


    @Override
    public int compareTo(Task task) {

        return task.created.compareTo(this.created);

    }

}

package pl.coderslab.spring_boot_project.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;

@Getter
@Setter
public class TaskDto {

    Long taskId;
    String name;
    Long daysToDeadline;
    String status;
    String lastImageSource;
}

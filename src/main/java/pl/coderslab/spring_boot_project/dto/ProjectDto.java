package pl.coderslab.spring_boot_project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDto {

    Long id;
    String projectName;
    String imagePath;
}

package pl.coderslab.spring_boot_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring_boot_project.model.Project;
import pl.coderslab.spring_boot_project.model.Task;

public interface ProjectRepository  extends JpaRepository<Project, Long> {


}

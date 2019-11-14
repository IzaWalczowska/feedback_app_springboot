package pl.coderslab.spring_boot_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.spring_boot_project.model.Project;
import pl.coderslab.spring_boot_project.model.Task;

import java.util.List;

public interface ProjectRepository  extends JpaRepository<Project, Long> {

    @Query(value = "select * from projects order by created DESC", nativeQuery = true)
    List<Project> findAllProjectsSorted();

}

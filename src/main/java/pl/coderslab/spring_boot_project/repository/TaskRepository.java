package pl.coderslab.spring_boot_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.spring_boot_project.model.Image;
import pl.coderslab.spring_boot_project.model.Task;
import pl.coderslab.spring_boot_project.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByProjectId(long id);


    @Query(value = "select * from tasks where project_id=?1 and task_status=?2", nativeQuery = true)
    List<Task> allInProjectByStatus(long id, TaskStatus taskStatus);

//    @Query(value = "select images from tasks where id=?1 order by created limit 1", nativeQuery = true)
//    Image findLastImageInTask(Long taskId);

}

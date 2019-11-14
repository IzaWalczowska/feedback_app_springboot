package pl.coderslab.spring_boot_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.spring_boot_project.model.Comment;
import pl.coderslab.spring_boot_project.model.Image;
import pl.coderslab.spring_boot_project.model.Review;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select * from comments where task_id=?1 order by created DESC limit 10", nativeQuery = true)
    List<Comment> findLastTenCommentsInTask(Long taskId);

}

package pl.coderslab.spring_boot_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.spring_boot_project.model.Image;
import pl.coderslab.spring_boot_project.model.Project;
import pl.coderslab.spring_boot_project.model.Review;

import java.util.List;

public interface ReviewRepository  extends JpaRepository<Review, Long> {

    @Query(value = "select * from reviews where task_id=?1 order by created limit 10", nativeQuery = true)
    List<Review> findLastTenReviewsInTask(Long taskId);

}

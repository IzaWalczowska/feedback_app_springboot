package pl.coderslab.spring_boot_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.spring_boot_project.model.Image;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query(value = "select * from images where task_id=?1 order by created DESC limit 10", nativeQuery = true)
    List<Image> findLastTenImagesInTask(Long taskId);

    @Query(value = "select * from images where task_id=?1 order by created DESC limit 1", nativeQuery = true)
    List<Image> findLastImageInTask(Long taskId);

    @Query(value = "select * from images where project_id=?1 order by created DESC limit 1", nativeQuery = true)
    List<Image> findLastImageInProject(Long taskId);

}

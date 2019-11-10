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

    @Query(value = "select * from images where project_id=?1 order by created limit 10", nativeQuery = true)
    List<Image> findLastTenImages(Long projectId);

//    @Query(value = "select * from images join tasks on images.task_id = tasks.id where project_id =?1 order by created desc limit 1", nativeQuery = true)
//    List<Image> findLatestImagesByProjectid(Long id);
//
//    @Query(value = "select * from images join tasks on images.task_id = tasks.id where project_id =?1 order by created desc limit 1", nativeQuery = true)
//    Image findLatestImageByProjectid(Long id);


}

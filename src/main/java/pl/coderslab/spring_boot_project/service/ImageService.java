package pl.coderslab.spring_boot_project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring_boot_project.model.Image;
import pl.coderslab.spring_boot_project.model.Project;
import pl.coderslab.spring_boot_project.repository.ImageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ImageService {

    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void save(Image image) {
        imageRepository.save(image);
    }

    public List<Image> findLastTen(Long projectId) {
        return imageRepository.findLastTenImages(projectId);
    }

//    todo rozwiazac problem wyswietlania okladek projektow
//    public List<Image> findLatestImageByProjectid(Long id) {
//        return imageRepository.findLatestImagesByProjectid(id);
//    }
//
//    public List<Image> findLatestImageByProjectList(List<Project> projectList) {
//        List<Image> imageList= new ArrayList<>();
//        for (Project project: projectList) {
//            Long id = project.getId();
//            imageList.add(imageRepository.findLatestImageByProjectid(id));
//        }
//        return imageList;
//    }


}


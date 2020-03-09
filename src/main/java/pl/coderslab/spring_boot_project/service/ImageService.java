package pl.coderslab.spring_boot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void save(Image image) {
        imageRepository.save(image);
    }

    public List<Image> findLastTenImagesInTask(Long taskId) {
        return imageRepository.findLastTenImagesInTask(taskId);
    }

    public Image findLastImageInTask(Long taskId) {
        if (imageRepository.findLastImageInTask(taskId).size() > 0) {
            return imageRepository.findLastImageInTask(taskId).get(0);
        } else {
            return null;
        }
    }

    public Image findLastImageInProject(Long projectId) {
        if (imageRepository.findLastImageInProject(projectId).size()>0) {
           return imageRepository.findLastImageInProject(projectId).get(0);
        } else {
            return null;
        }
    }

}


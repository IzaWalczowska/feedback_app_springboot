package pl.coderslab.spring_boot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring_boot_project.model.Image;
import pl.coderslab.spring_boot_project.model.Project;
import pl.coderslab.spring_boot_project.model.ProjectDto;
import pl.coderslab.spring_boot_project.repository.ProjectRepository;
import pl.coderslab.spring_boot_project.repository.TaskRepository;


import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ImageService imageService;

    @Autowired
    public ProjectService(TaskRepository taskRepository, ProjectRepository projectRepository, ImageService imageService) {
        this.projectRepository = projectRepository;
        this.imageService = imageService;
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public List<Project> findAllProjectsSorted() {
        return projectRepository.findAllProjectsSorted();
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

//    public List<Project> findAllWithOneImage() {
//
//        List<Project> list = projectRepository.findAll();
//        for (Project project : list) {
//
//        }
//
//        return list;
//
//    }

    public List<ProjectDto> createProjectDtosList(List<Project> projectList) {
        List<ProjectDto> projectDtoList = new ArrayList<>();
        for (Project project : projectList) {
            ProjectDto dto = new ProjectDto();
            dto.setId(project.getId());
            dto.setProjectName(project.getName());
            Image lastImage = imageService.findLastImageInTask(project.getId());
            String imagePath = "";
            if(lastImage != null){
                imagePath = imageService.findLastImageInTask(project.getId()).getPath();
            }
            dto.setImagePath(imagePath);
            projectDtoList.add(dto);
        }
        return projectDtoList;
    }


}

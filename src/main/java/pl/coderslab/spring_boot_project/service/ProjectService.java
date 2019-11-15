package pl.coderslab.spring_boot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring_boot_project.model.Image;
import pl.coderslab.spring_boot_project.model.Project;
import pl.coderslab.spring_boot_project.model.ProjectDto;
import pl.coderslab.spring_boot_project.model.Task;
import pl.coderslab.spring_boot_project.repository.ProjectRepository;
import pl.coderslab.spring_boot_project.repository.TaskRepository;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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


    public List<ProjectDto> createProjectDtosList(List<Project> projectList) {
        List<ProjectDto> projectDtoList = new ArrayList<>();
        for (Project project : projectList) {
            ProjectDto dto = new ProjectDto();
            dto.setId(project.getId());
            dto.setProjectName(project.getName());
               if(imageService.findLastImageInProject(project.getId()) != null){
                String imagePath = imageService.findLastImageInProject(project.getId()).getPath();
                dto.setImagePath(imagePath);
            }
            projectDtoList.add(dto);
        }
        return projectDtoList;
    }
    public Long countDaysToProjectDeadline(Long id) {
        Project project = findById(id);
        Date deadline = project.getDeadline();
        Date currentDate = new Date();

        long diffInMillies = Math.abs(deadline.getTime() - currentDate.getTime());
        long remainingDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return remainingDays;
    }

    public String formatDate(Date javaUtilDate) throws ParseException {
        return threadSafeFormatter.get().format(javaUtilDate);
    }

    private static ThreadLocal<SimpleDateFormat> threadSafeFormatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MM-yyyy"));


}

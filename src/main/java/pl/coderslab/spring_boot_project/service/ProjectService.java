package pl.coderslab.spring_boot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring_boot_project.model.Project;
import pl.coderslab.spring_boot_project.repository.ProjectRepository;
import pl.coderslab.spring_boot_project.repository.TaskRepository;


import java.util.List;

@Service
@Transactional
public class ProjectService {

private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id){return projectRepository.findById(id).orElse(null);}

    public List<Project> findAllWithOneImage() {

        List<Project> list = projectRepository.findAll();
        for (Project project: list) {

        }

        return list;

    }



}

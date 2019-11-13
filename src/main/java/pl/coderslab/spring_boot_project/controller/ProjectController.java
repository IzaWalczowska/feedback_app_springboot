package pl.coderslab.spring_boot_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring_boot_project.model.Project;
import pl.coderslab.spring_boot_project.model.Request;
import pl.coderslab.spring_boot_project.model.Task;
import pl.coderslab.spring_boot_project.service.ImageService;
import pl.coderslab.spring_boot_project.service.ProjectService;
import pl.coderslab.spring_boot_project.service.RequestService;
import pl.coderslab.spring_boot_project.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProjectController {

    private ProjectService projectService;
    private TaskService taskService;
    private final RequestService requestService;
    private final ImageService imageService;

    @Autowired
    public ProjectController(ProjectService projectService, TaskService taskService, RequestService requestService, ImageService imageService) {
        this.projectService = projectService;
        this.taskService = taskService;
        this.requestService = requestService;
        this.imageService = imageService;
    }

    @GetMapping("/projekty")
    public String showProjects(Model model) {
        List<Project> projectsList = projectService.findAll();
        Project project = new Project();
        model.addAttribute("project", project);
        if (projectsList != null) {
            model.addAttribute("projectsList", projectsList);
        }
        return "projectsList";
    }


    @PostMapping("/projekty")
    public String createProject(@Valid @ModelAttribute Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "projectsList";
        }
        projectService.save(project);
        return "redirect:/projekty";
    }

    @GetMapping("/projekt/{id}")
    public String showTasks(@PathVariable long id, Model model) {

        model.addAttribute("projectId", id);
        List<Task> tasksList = taskService.findByProjectId(id);

        // TODO: to be tesed
//        for (Task task:tasksList) {
//            Long taskId = task.getId();
//            List<Request> requestsList = requestService.findAllRequestsInTask(taskId);
//            String attribiteName = taskId.toString();
//            model.addAttribute(attribiteName, requestsList);
//        }
        model.addAttribute("tasksList", tasksList);
        Task task = new Task();
        model.addAttribute("task", task);

        return "project";
    }

    @PostMapping("/projekt/{id}")
    public String createTask(@Valid @ModelAttribute Task task, BindingResult result, @PathVariable long id) {
        if (result.hasErrors()) {
            return "project";
        }
        task.setProject(projectService.findById(id));
        taskService.save(task);
        return "redirect:/projekt/" + id;
    }


}

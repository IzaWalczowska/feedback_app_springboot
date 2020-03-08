package pl.coderslab.spring_boot_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring_boot_project.dto.ProjectDto;
import pl.coderslab.spring_boot_project.dto.TaskDto;
import pl.coderslab.spring_boot_project.model.*;
import pl.coderslab.spring_boot_project.service.ImageService;
import pl.coderslab.spring_boot_project.service.ProjectService;
import pl.coderslab.spring_boot_project.service.RequestService;
import pl.coderslab.spring_boot_project.service.TaskService;

import javax.validation.Valid;
import java.text.ParseException;
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
        List<Project> projectsList = projectService.findAllProjectsSorted();
        List<ProjectDto> projectDtoList = projectService.createProjectDtosList(projectsList);


        Project project = new Project();
        model.addAttribute("project", project);
        if (projectDtoList != null) {
            model.addAttribute("projectDtoList", projectDtoList);
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
    public String showTasks(@PathVariable Long id, Model model) throws ParseException {

        Task task = new Task();
        model.addAttribute("task", task);

        model.addAttribute("projectId", id);
        List<Task> tasksList = taskService.findAllByProjectIdOrderByCreatedDesc(id);



        Project project = projectService.findById(id);
        model.addAttribute("project", project);

        String deadlineDate = projectService.formatDate(project.getDeadline());
        model.addAttribute("deadlineDate", deadlineDate);


        Long daysToProjectDeadline =projectService.countDaysToProjectDeadline(id);
        model.addAttribute("daysToDeadline", daysToProjectDeadline);

        if(tasksList !=null && tasksList.size()>0){
        List<TaskDto> taskDtoList = taskService.createTaskDtoList(tasksList);
        model.addAttribute("taskDtoList", taskDtoList);}


        int tasksCount = taskService.countByProjectId(id);
        model.addAttribute("taskCount", tasksCount);

        int finishedTasksCount = taskService.countallInProjectByStatus(id, TaskStatus.ACCEPTED.name());
        model.addAttribute("finishedTasksCount", finishedTasksCount);

        int ongoingTasksCount = taskService.countallInProjectByStatus(id, TaskStatus.ONGOING.name());
        model.addAttribute("ongoingTasksCount", ongoingTasksCount);

        int toReviewTasksCount = taskService.countallInProjectByStatus(id, TaskStatus.TO_REVIEW.name());
        model.addAttribute("toReviewTasksCount", toReviewTasksCount);

        int waitingTasksCount = taskService.countallInProjectByStatus(id, TaskStatus.WAITING.name());
        model.addAttribute("waitingTasksCount", waitingTasksCount);

        return "project";
    }

    @PostMapping("/projekt/{projectId}")
    public String createTask(@Valid @ModelAttribute Task task, BindingResult result, @PathVariable Long projectId) {
        if (result.hasErrors()) {
            return "project";
        }

        task.setProject(projectService.findById(projectId));
        taskService.save(task);

        return "redirect:/projekt/" + projectId;
    }


}

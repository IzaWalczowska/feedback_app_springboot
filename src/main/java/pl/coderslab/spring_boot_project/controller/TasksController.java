package pl.coderslab.spring_boot_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.spring_boot_project.model.*;
import pl.coderslab.spring_boot_project.service.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

//@Controller
////@RequestMapping("task/{projectId}/zadanie/{taskId}")
//public class TasksController {
//
//    private TaskService taskService;
//    private ProjectService projectService;
//
//    private StorageService storageService;
//    private final ImageService imageService;
//    private final DTOService dtoService;
//    private final CommentService commentService;
//
//    @Autowired
//    public TasksController(TaskService taskService, ProjectService projectService, StorageService storageService, ImageService imageService, DTOService dtoService, CommentService commentService) {
//        this.taskService = taskService;
//        this.projectService = projectService;
//        this.storageService = storageService;
//        this.imageService = imageService;
//        this.dtoService = dtoService;
//        this.commentService = commentService;
//    }
//
//    @GetMapping("task/{projectId}/{taskId}/history")
//    public String showTaskHistory(@PathVariable("projectId") Long projectId, @PathVariable("taskId") Long taskId, Model model) {
//
//        Task task = taskService.findById(taskId);
//        model.addAttribute("task", task);
////creates new comment file to be filled
//        Comment comment = new Comment();
//        model.addAttribute("comment", comment);
////        crete mainPath to resolve mapping issues
//        String mainPath = "task/" + projectId + "/" + taskId;
////        String mainPath = " ";
//        model.addAttribute("mainPath", mainPath);
//
//        List<historyDto> historyList = dtoService.selectImagesAsDto(projectId);
//        historyList.addAll(dtoService.selectReviewsAsDto());
//        historyList.addAll(dtoService.selectCommentsAsDto());
//        Collections.sort(historyList);
//        model.addAttribute("historyList", historyList);
//
//        return "taskHistory";
//    }
//
//    @PostMapping("task/{projectId}/{taskId}/history")
//    public String createComment(@PathVariable("projectId") Long projectId, @PathVariable("taskId") Long taskId,
//                                @ModelAttribute Comment comment, BindingResult result) {
//
//        if (comment != null) {
//            commentService.save(comment);
//        }
//        result.setNestedPath(null);
//        return "redirect:task/" + projectId + "/" + taskId + "/history";
//    }
//
//
//    @GetMapping("task/{projectId}/zadanie/{taskId}/uploadImage")
//    public String getSingleUploadPage() {
//        return "uploadImage";
//    }
//
//    @PostMapping("task/{projectId}/zadanie/{taskId}/uploadImage")
//    public String uploadImage(@RequestParam("uploadFile") MultipartFile file, @PathVariable("projectId") Long projectId, @PathVariable("taskId") Long taskId, Model model) throws IOException {
//
////      saves upleaded file and returns the path, to be written to the database
//        String path = storageService.uploadFile(file);
//
////      creates Image object, fills is's fields and saves to database
//        Image image = new Image();
//        image.setTask(taskService.findById(taskId));
//        image.setProject(projectService.findById(projectId));
//        image.setPath(path);
//        imageService.save(image);
//
////        update tasks status
//        Task task = taskService.findById(taskId);
//        String newStatus = TaskStatus.TO_REVIEW.name();
//        task.setTaskStatus(newStatus);
//        taskService.save(task);
//
//        return "redirect:/history";
//    }

//    @ModelAttribute("projectPathId")
//    public Long projectPathId(@PathVariable("projectId") Long projectPathId) {
//        return projectPathId;
//    }
//
//    @ModelAttribute("taskPathId")
//    public Long taskPathId(@PathVariable("taskId") Long taskPathId) {
//        return taskPathId;
//    }
//}


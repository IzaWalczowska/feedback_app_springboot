package pl.coderslab.spring_boot_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.spring_boot_project.model.Comment;
import pl.coderslab.spring_boot_project.model.Image;
import pl.coderslab.spring_boot_project.model.Task;
import pl.coderslab.spring_boot_project.model.historyDto;
import pl.coderslab.spring_boot_project.service.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

//@Controller
//public class TasksController2 {
//
//    private TaskService taskService;
//    private ProjectService projectService;
//    private FileService fileService;
//    private StorageService storageService;
//    private final ImageService imageService;
//    private final DTOService dtoService;
//    private final CommentService commentService;
//
//    public TasksController2(TaskService taskService, ProjectService projectService, FileService fileService, StorageService storageService, ImageService imageService, DTOService dtoService, CommentService commentService) {
//        this.taskService = taskService;
//        this.projectService = projectService;
//        this.fileService = fileService;
//        this.storageService = storageService;
//        this.imageService = imageService;
//        this.dtoService = dtoService;
//        this.commentService = commentService;
//    }
//
//    @GetMapping("projekt/{projectId}/zadanie/{taskId}")
//    public String showTaskHistory(@PathVariable("projectId") Long projectId, @PathVariable("taskId") Long taskId, Model model) {
//
//        Task task = taskService.findById(taskId);
//        model.addAttribute("task", task);
//
//        Comment comment = new Comment();
//        model.addAttribute("comment", comment);
//
//        List<historyDto> historyList = dtoService.selectImagesAsDto();
//        historyList.addAll(dtoService.selectReviewsAsDto());
//        historyList.addAll(dtoService.selectCommentsAsDto());
//        Collections.sort(historyList);
//        model.addAttribute("historyList", historyList);
//
//        return "taskHistory";
//    }
//
//    @PostMapping("projekt/{projectId}/zadanie/{taskId}/skomentuj")
//    public String createComment(@PathVariable("projectId") Long projectId, @PathVariable("taskId") Long taskId, @ModelAttribute Comment comment, BindingResult result) {
//        if (result.hasErrors()) {
//            return "taskHistory";
//        }
//        commentService.save(comment);
//
//        return "redirect:";
//    }
//
//    @GetMapping("projekt/{projectId}/zadanie/{taskId}/wczytaj")
//    public String getSingleUploadPage() {
//        return "uploadImage";
//    }
//
//    @PostMapping("projekt/{projectId}/zadanie/{taskId}/wczytaj")
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
//        return "redirect:zadanie/" + taskId;
//    }
//
//    @ModelAttribute("projectId")
//    public Long projectId(@PathVariable("projectId") Long projectId) {
//        return projectId;
//    }
//}
//

package pl.coderslab.spring_boot_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.spring_boot_project.model.*;
import pl.coderslab.spring_boot_project.service.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/task")
public class NewTaskController {

    private final DTOService dtoService;
    private final TaskService taskService;
    private final ProjectService projectService;
    private final CommentService commentService;
    private final StorageService storageService;
    private final ImageService imageService;
    private final ReviewService reviewService;
    private final RequestService requestService;

    @Autowired
    public NewTaskController(DTOService dtoService, TaskService taskService, ProjectService projectService, CommentService commentService, StorageService storageService, ImageService imageService, ReviewService reviewService, RequestService requestService) {
        this.dtoService = dtoService;
        this.taskService = taskService;
        this.projectService = projectService;
        this.commentService = commentService;
        this.storageService = storageService;
        this.imageService = imageService;
        this.reviewService = reviewService;
        this.requestService = requestService;
    }

    @GetMapping("/{projectId}/{taskId}")
    public String showTaskHistory(@PathVariable("projectId") Long projectId, @PathVariable("taskId") Long taskId, Model model) {

        model.addAttribute("projectId", projectId);
        model.addAttribute("taskId", taskId);

        Comment comment = new Comment();
        model.addAttribute("comment", comment);

        Project tasksProject = projectService.findById(projectId);
        model.addAttribute("project", tasksProject);

        List<Task> tasksList = taskService.findByProjectId(projectId);
        model.addAttribute("tasksList", tasksList);

        List<HistoryDto> historyList = dtoService.latestDtosListSorted(taskId);
        model.addAttribute("historyList", historyList);


        List<Request> checkedRequestsList = requestService.selectAllCheckedRequestsInTask(taskId);
        model.addAttribute("checkedRequestsList", checkedRequestsList);

        List<Request> uncheckedRequestsList = requestService.selectAllUncheckedRequestsInTask(taskId);
        model.addAttribute("uncheckedRequestsList", uncheckedRequestsList);


        return "taskHistory";
    }

    @PostMapping("/{projectId}/{taskId}")
    public String addCommentToHistory(@ModelAttribute Comment comment, @PathVariable("taskId") Long taskId) {

        comment.setTask(taskService.findById(taskId));
        commentService.save(comment);

        return "redirect:" + taskId;

    }

    @GetMapping("/{projectId}/{taskId}/uploadImage")
    public String getSingleUploadPage() {
        return "uploadImage";
    }

    @PostMapping("/{projectId}/{taskId}/uploadImage")
    public String uploadImage(@RequestParam("uploadFile") MultipartFile file,
                              @PathVariable("projectId") Long projectId,
                              @PathVariable("taskId") Long taskId, Model model) throws IOException {

//      saves upleaded file and returns the path, to be written to the database
        String path = storageService.uploadFile(file);

//      creates Image object, fills is's fields and saves to database
        Image image = new Image();
        image.setTask(taskService.findById(taskId));
        image.setProject(projectService.findById(projectId));
        image.setPath(path);
        imageService.save(image);

//        update tasks status
        Task task = taskService.findById(taskId);
        String newStatus = TaskStatus.TO_REVIEW.name();
        task.setTaskStatus(newStatus);
        taskService.save(task);

        return "redirect:../" + taskId;
    }

    @GetMapping("/{projectId}/{taskId}/review")
    public String createReview(Model model) {
        return "review";
    }

    @PostMapping("/{projectId}/{taskId}/review")
    public String createReview(@RequestParam("request") List<String> stringRequest, @PathVariable("taskId") Long taskId) {

        Review newReview = new Review();
        newReview.setTask(taskService.findById(taskId));
        newReview.setImage(imageService.findLastImageInTask(taskId));
        Long reviewId = reviewService.saveReviewReturnId(newReview);

        List<String> list = stringRequest;
        List<Request> requestsList = requestService.createNewRequestsList(list, reviewId);

        Review review = reviewService.findReviewById(reviewId);
        review.setRequest(requestsList);
        reviewService.saveReview(review);

        Task task = taskService.findById(taskId);
        String newStatus = TaskStatus.ONGOING.name();
        task.setTaskStatus(newStatus);
        taskService.save(task);

        return "redirect:../" + taskId;
    }

    @GetMapping("/{projectId}/{taskId}/{requestId}")
    public String getSingleUploadPage(@PathVariable("taskId") Long taskId, @PathVariable("requestId") Long requestId) {
        Request request = requestService.findOne(requestId);
        if (request.getStatus() == false) {
            request.setStatus(true);
        } else {
            request.setStatus(false);
        }
        requestService.save(request);
        return "redirect:../" + taskId;
    }

    @GetMapping("/{projectId}/{taskId}/accept")
    public String acceptTask(@PathVariable("taskId") Long taskId){
        Task task = taskService.findById(taskId);
        String newStatus = TaskStatus.ACCEPTED.name();
        task.setTaskStatus(newStatus);
        taskService.save(task);
        return "redirect:../" + taskId;
    }
}


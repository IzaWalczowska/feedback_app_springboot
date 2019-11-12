package pl.coderslab.spring_boot_project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring_boot_project.model.Comment;
import pl.coderslab.spring_boot_project.model.historyDto;
import pl.coderslab.spring_boot_project.model.Image;
import pl.coderslab.spring_boot_project.model.Review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
@Transactional
public class DTOService {

    private final ImageService imageService;
    private final ReviewService reviewService;
    private final CommentService commentService;
    private final RequestService requestService;

    public DTOService(ImageService imageService, ReviewService reviewService, CommentService commentService, RequestService requestService) {
        this.imageService = imageService;
        this.reviewService = reviewService;
        this.commentService = commentService;
        this.requestService = requestService;
    }

    public List<historyDto> selectImagesAsDto(Long taskId) {
        List<Image> imageList = imageService.findLastTenImagesInTask(taskId);
        List<historyDto> historyDtoList = new ArrayList<>();
        for (Image image : imageList
        ) {
            historyDto historyDto = new historyDto();
            historyDto.setCreated(image.getCreated().toString());
            historyDto.setImageSource(image.getPath());
            historyDtoList.add(historyDto);
        }

        return historyDtoList;
    }

    public List<historyDto> selectReviewsAsDto(Long taskId) {
        List<Review> reviewList = reviewService.findLastTenReviewsInTask(taskId);
        List<historyDto> historyDtoList = new ArrayList<>();
        for (Review review : reviewList) {
            historyDto historyDto = new historyDto();
            historyDto.setCreated(review.getCreated().toString());
            historyDto.setContent(review.getContent());
            List<String> stringRequests = requestService.createStringRequestList(review.getRequest());
            historyDto.setRequests(stringRequests);
            historyDtoList.add(historyDto);
        }
        return historyDtoList;
    }

    public List<historyDto> selectCommentsAsDto(Long taskId) {
        List<historyDto> historyDtoList = new ArrayList<>();
        List<Comment> commentlist = commentService.findLastTenComments(taskId);
        for (Comment comment : commentlist) {
            historyDto historyDto = new historyDto();
            historyDto.setCreated(comment.getCreated().toString());
            historyDto.setContent(comment.getContent());
            historyDtoList.add(historyDto);
        }
        return historyDtoList;
    }

    public List<historyDto> latestDtosListSorted(Long taskId) {

        List<historyDto> historyList = selectImagesAsDto(taskId);
        historyList.addAll(selectReviewsAsDto(taskId));
        historyList.addAll(selectCommentsAsDto(taskId));
        Collections.sort(historyList);

        return historyList;

    }


}

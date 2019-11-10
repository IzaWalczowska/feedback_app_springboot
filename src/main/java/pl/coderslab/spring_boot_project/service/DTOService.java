package pl.coderslab.spring_boot_project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring_boot_project.model.Comment;
import pl.coderslab.spring_boot_project.model.historyDto;
import pl.coderslab.spring_boot_project.model.Image;
import pl.coderslab.spring_boot_project.model.Review;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class DTOService {

    private final ImageService imageService;
    private final ReviewService reviewService;
    private final CommentService commentService;

    public DTOService(ImageService imageService, ReviewService reviewService, CommentService commentService) {
        this.imageService = imageService;
        this.reviewService = reviewService;
        this.commentService = commentService;
    }

    public List<historyDto> selectImagesAsDto(Long projectId) {
        List<Image> imageList = imageService.findLastTen(projectId);
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

    public List<historyDto> selectReviewsAsDto() {
        List<Review> reviewList = reviewService.findLastTenReviews();
        List<historyDto> historyDtoList = new ArrayList<>();
        for (Review review : reviewList) {
            historyDto historyDto = new historyDto();
            historyDto.setCreated(review.getCreated().toString());
        }
        return historyDtoList;
    }

    public List<historyDto> selectCommentsAsDto() {
        List<historyDto> historyDtoList = new ArrayList<>();
        List<Comment> commentlist = commentService.findLastTenComments();
        for (Comment comment : commentlist) {
            historyDto historyDto = new historyDto();
            historyDto.setCreated(comment.getCreated().toString());
            historyDto.setContent(comment.getContent());
            historyDtoList.add(historyDto);
        }
        return historyDtoList;
    }

//    public List<DTO> margeDtoListsSorted(List<DTO> dtoList1, List<DTO> dtoList2, List<DTO> dtoList3) {
//
//        List<DTO> newList = ListUtils.union(dtoList1, dtoList2);
//        newList.addAll(dtoList3);
//        Collections.sort(newList);
//
//        return newList;
//
//    }


}

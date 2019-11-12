package pl.coderslab.spring_boot_project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring_boot_project.model.Request;
import pl.coderslab.spring_boot_project.model.Review;
import pl.coderslab.spring_boot_project.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;


    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void saveReview(Review review){reviewRepository.save(review);}

    public Review findReviewById(Long id){return reviewRepository.findById(id).orElse(null);}

    public List<Review> findLastTenReviewsInTask(Long taskId) {
        return reviewRepository.findLastTenReviewsInTask(taskId);
    }

    public Long saveReviewReturnId(Review review){
        reviewRepository.save(review);
        return review.getId();
    }

}


package pl.coderslab.spring_boot_project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring_boot_project.model.Request;
import pl.coderslab.spring_boot_project.repository.RequestRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RequestService {

    private final RequestRepository requestRepository;
    private final ReviewService reviewService;

    public RequestService(RequestRepository requestRepository, ReviewService reviewService) {
        this.requestRepository = requestRepository;
        this.reviewService = reviewService;
    }

    public void save(Request request) {
        requestRepository.save(request);
    }

    public List<Request> createRequestsList(List<String> list, Long reviewId) {
        List<Request> requestsList = new ArrayList<>();
        for (String stringRequest : list) {
            Request request = new Request();
            request.setCreated(reviewService.findReviewById(reviewId).getCreated());
            request.setRequest(stringRequest);
            request.setReview(reviewService.findReviewById(reviewId));
            save(request);
            requestsList.add(request);
        }
        return requestsList;
    }

    public List<String> createStringRequestList(List<Request> list) {
        List<String> stringRequests = new ArrayList<>();
        for (Request request : list) {
            stringRequests.add(request.getRequest());
        }
        return stringRequests;
    }
}

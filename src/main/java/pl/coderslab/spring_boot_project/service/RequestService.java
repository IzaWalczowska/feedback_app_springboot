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

    public Request findOne(Long id){return requestRepository.findById(id).orElse(null);}

    public void save(Request request) {
        requestRepository.save(request);
    }

    public List<Request> createNewRequestsList(List<String> list, Long reviewId) {
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

    public List<Request> findAllRequestsInTask(Long taskId){
        return requestRepository.findAllRequestsInTask(taskId);
    }

    public List<Request> selectAllCheckedRequestsInTask(Long taskId){
        List<Request> allRequests=findAllRequestsInTask(taskId);
        List<Request> checkedRequests=new ArrayList<>();
        for (Request request: allRequests) {
            if(request != null && request.getStatus() == true){
                checkedRequests.add(request);
            }
        }
        return checkedRequests;
    }
    public List<Request> selectAllUncheckedRequestsInTask(Long taskId){
        List<Request> allRequests=findAllRequestsInTask(taskId);
        List<Request> uncheckedRequests=new ArrayList<>();
        for (Request request: allRequests) {
            if(request != null && request.getStatus() == false){
                uncheckedRequests.add(request);
            }
        }
        return uncheckedRequests;
    }
}



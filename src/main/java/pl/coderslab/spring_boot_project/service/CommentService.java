package pl.coderslab.spring_boot_project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring_boot_project.model.Comment;
import pl.coderslab.spring_boot_project.repository.CommentRepository;

import java.util.List;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findLastTenComments(Long taskId) {
        return commentRepository.findLastTenCommentsInTask(taskId);
    }

    public void save(Comment comment){commentRepository.save(comment);}
}

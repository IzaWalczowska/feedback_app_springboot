package pl.coderslab.spring_boot_project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring_boot_project.model.Task;
import pl.coderslab.spring_boot_project.repository.TaskRepository;


import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public void save(Task task) {
        taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task> findByProjectId(long id) {return taskRepository.findAllByProjectId(id);};

    public Task findById (Long id){return taskRepository.findById(id).orElse(null);}


}

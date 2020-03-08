package pl.coderslab.spring_boot_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.spring_boot_project.model.Task;
import pl.coderslab.spring_boot_project.dto.TaskDto;
import pl.coderslab.spring_boot_project.repository.TaskRepository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;
    private final ImageService imageService;

    @Autowired
    public TaskService(TaskRepository taskRepository, ImageService imageService) {
        this.taskRepository = taskRepository;
        this.imageService = imageService;
    }


    public void save(Task task) {
        taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task> findByProjectId(long id) {
        return taskRepository.findAllByProjectId(id);
    }

    public List<Task> findAllByProjectIdOrderByCreatedDesc(long id) {
        return taskRepository.findAllByProjectIdOrderByCreatedDesc(id);
    }


    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public int countByProjectId(Long id) {
        return taskRepository.findAllByProjectId(id).size();
    }

    public int countallInProjectByStatus(Long id, String taskStatus) {
        return taskRepository.allInProjectByStatus(id, taskStatus).size();
    }

    public List<TaskDto> createTaskDtoList(List<Task> taksList) {
        List<TaskDto> taskDtoList = new ArrayList<>();
        for (Task task : taksList) {
            TaskDto taskDto = new TaskDto();
            taskDto.setTaskId(task.getId());
            taskDto.setName(task.getName());
            taskDto.setStatus(task.getTaskStatus());
            if (imageService.findLastImageInTask(task.getId()) != null) {
                String lastImageSource = imageService.findLastImageInTask(task.getId()).getPath();
                taskDto.setLastImageSource(lastImageSource);
            }

            taskDto.setDaysToDeadline(countDaysToDeadline(task.getId()));
            taskDtoList.add(taskDto);
        }
        return taskDtoList;
    }

    public Long countDaysToDeadline(Long id) {
        Task task = findById(id);
        Date deadline = task.getDeadline();
        Date currentDate = new Date();

        long diffInMillies = Math.abs(deadline.getTime() - currentDate.getTime());
        long remainingDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return remainingDays;
    }
}

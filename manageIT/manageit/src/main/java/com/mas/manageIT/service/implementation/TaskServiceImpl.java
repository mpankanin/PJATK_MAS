package com.mas.manageIT.service.implementation;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.exception.TaskNotFoundException;
import com.mas.manageIT.model.Task;
import com.mas.manageIT.repository.TaskRepository;
import com.mas.manageIT.service.TaskService;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAll() {
        try {
            return (List<Task>) ObjectPlus.getExtent(Task.class);
        } catch (ClassNotFoundException e) {
            Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
            logger.error(() -> "Couldn't get a task's extent.");
        }
        return new ArrayList<>();
    }

    @Override
    public Task add(Task task) {
        return task;
    }

    @Override
    public Task update(long taskId, Task task) {
        try {
            List<Task> extent = (List<Task>) ObjectPlus.getExtent(Task.class);
            Optional<Task> optional = extent.stream().filter(t -> t.getId().equals(taskId)).findFirst();
            if (optional.isPresent()) {
                Task taskRetrieved = optional.get();
                taskRetrieved.setFinishDate(task.getFinishDate());
                return taskRetrieved;
            } else {
                throw new TaskNotFoundException("Task: " + taskId + " doesn't exist.");
            }
        } catch (ClassNotFoundException e) {
            Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
            logger.error(() -> "Couldn't get a task's extent.");
        }
        return null;
    }

}

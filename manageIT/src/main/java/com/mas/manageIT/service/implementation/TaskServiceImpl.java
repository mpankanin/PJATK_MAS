package com.mas.manageIT.service.implementation;

import com.mas.manageIT.repository.TaskRepository;
import com.mas.manageIT.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

}

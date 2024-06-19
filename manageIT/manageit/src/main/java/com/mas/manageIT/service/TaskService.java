package com.mas.manageIT.service;

import com.mas.manageIT.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();
    Task add(Task task);
    Task update(long taskId, Task task);
}


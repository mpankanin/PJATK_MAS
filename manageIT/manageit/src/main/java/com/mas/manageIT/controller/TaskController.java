package com.mas.manageIT.controller;

import com.mas.manageIT.model.Task;
import com.mas.manageIT.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<Task>> getAll(@PathVariable long projectId) {
        List<Task> tasks = taskService.getAll();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/add")
    public ResponseEntity<Task> add(@RequestBody Task task) {
        Task newTask = taskService.add(task);
        return ResponseEntity.ok(newTask);
    }

    @PutMapping("/update/{taskId}")
    public ResponseEntity<Task> update(@PathVariable long taskId, @RequestBody Task task) {
        Task updatedTask = taskService.update(taskId, task);
        return ResponseEntity.ok(updatedTask);
    }

}

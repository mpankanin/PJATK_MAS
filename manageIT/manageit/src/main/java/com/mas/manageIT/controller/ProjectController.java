package com.mas.manageIT.controller;

import com.mas.manageIT.model.Project;
import com.mas.manageIT.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;


    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    public ResponseEntity<Project> add(@RequestBody Project project) {
        Project newProject = projectService.add(project);
        return ResponseEntity.ok(newProject);
    }

}

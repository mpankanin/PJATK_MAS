package com.mas.manageIT.service.implementation;

import com.mas.manageIT.repository.ProjectRepository;
import com.mas.manageIT.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

}

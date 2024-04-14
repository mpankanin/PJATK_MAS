package com.mas.manageIT.service.implementation;

import com.mas.manageIT.repository.ProjectTeamRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectTeamServiceImpl {

    private final ProjectTeamRepository projectTeamRepository;

    public ProjectTeamServiceImpl(ProjectTeamRepository projectTeamRepository) {
        this.projectTeamRepository = projectTeamRepository;
    }

}

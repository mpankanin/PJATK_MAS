package com.mas.manageIT.service.implementation;

import com.mas.manageIT.repository.ProjectTeamRepository;
import com.mas.manageIT.service.ProjectTeamService;
import org.springframework.stereotype.Service;

@Service
public class ProjectTeamServiceImpl implements ProjectTeamService {

    private final ProjectTeamRepository projectTeamRepository;

    public ProjectTeamServiceImpl(ProjectTeamRepository projectTeamRepository) {
        this.projectTeamRepository = projectTeamRepository;
    }

}

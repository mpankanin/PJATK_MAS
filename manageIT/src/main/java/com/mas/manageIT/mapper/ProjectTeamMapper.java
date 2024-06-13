package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.ProjectTeamEntity;
import com.mas.manageIT.model.ProjectTeam;

public class ProjectTeamMapper {

    public static ProjectTeam toModel(ProjectTeamEntity projectTeamEntity) {
        ProjectTeam projectTeam = new ProjectTeam();

        projectTeam.setId(projectTeamEntity.getId());
        projectTeam.setName(projectTeamEntity.getName());
        return projectTeam;
    }

    public static ProjectTeamEntity toEntity(ProjectTeam projectTeam){
        ProjectTeamEntity projectTeamEntity = new ProjectTeamEntity();

        projectTeamEntity.setId(projectTeam.getId());
        projectTeamEntity.setName(projectTeam.getName());
        return projectTeamEntity;
    }

}

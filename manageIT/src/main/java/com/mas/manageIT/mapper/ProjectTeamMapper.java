package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.ProjectTeamEntity;
import com.mas.manageIT.model.Employer;
import com.mas.manageIT.model.ProjectTeam;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProjectTeamMapper {

    public static ProjectTeam toModel(ProjectTeamEntity projectTeamEntity) {
        ProjectTeam projectTeam = new ProjectTeam();
        projectTeam.setId(projectTeamEntity.getId());
        projectTeam.setName(projectTeamEntity.getName());
        projectTeam.setProjects(projectTeamEntity.getProjects().stream().map(ProjectMapper::toModel).collect(Collectors.toList()));
        projectTeam.setTeamMembers(projectTeamEntity.getTeamMembers().stream().map(EmployerMapper::toModel).toList().toArray(new Employer[projectTeam.getMaxEmployers()]));
        return projectTeam;
    }

    public static ProjectTeamEntity toEntity(ProjectTeam projectTeam){
        ProjectTeamEntity projectTeamEntity = new ProjectTeamEntity();
        projectTeamEntity.setId(projectTeam.getId());
        projectTeamEntity.setName(projectTeam.getName());
        projectTeamEntity.setProjects(projectTeam.getProjects().stream().map(ProjectMapper::toEntity).collect(Collectors.toList()));
        projectTeamEntity.setTeamMembers(Arrays.stream(projectTeam.getTeamMembers()).map(EmployerMapper::toEntity).collect(Collectors.toList()));
        return projectTeamEntity;
    }

}

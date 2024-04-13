package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.ProjectEntity;
import com.mas.manageIT.model.Project;

import java.util.stream.Collectors;

public class ProjectMapper {

    public static Project toModel(ProjectEntity projectEntity) {
        Project project = new Project();
        project.setId(projectEntity.getId());
        project.setDescription(projectEntity.getDescription());
        project.setOrder(OrderMapper.toModel(projectEntity.getOrder()));
        project.setProjectTeam(ProjectTeamMapper.toModel(projectEntity.getProjectTeam()));
        project.setTasks(projectEntity.getTasks().stream().map(TaskMapper::toModel).collect(Collectors.toList()));
        return project;
    }

    public static ProjectEntity toEntity(Project project){
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(project.getId());
        projectEntity.setDescription(project.getDescription());
        projectEntity.setOrder(OrderMapper.toEntity(project.getOrder()));
        projectEntity.setProjectTeam(ProjectTeamMapper.toEntity(project.getProjectTeam()));
        projectEntity.setTasks(project.getTasks().stream().map(TaskMapper::toEntity).collect(Collectors.toList()));
        return projectEntity;
    }

}

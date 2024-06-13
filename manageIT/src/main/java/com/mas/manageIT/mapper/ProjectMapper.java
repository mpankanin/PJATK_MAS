package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.ProjectEntity;
import com.mas.manageIT.model.Project;

public class ProjectMapper {

    public static Project toModel(ProjectEntity projectEntity) {
        Project project = new Project();

        project.setId(projectEntity.getId());
        project.setName(projectEntity.getName());
        project.setDescription(projectEntity.getDescription());
        project.setStartDate(projectEntity.getStartDate());
        project.setFinishDate(projectEntity.getFinishDate());
        return project;
    }

    public static ProjectEntity toEntity(Project project){
        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setId(project.getId());
        projectEntity.setName(project.getName());
        projectEntity.setDescription(project.getDescription());
        projectEntity.setStartDate(project.getStartDate());
        projectEntity.setFinishDate(project.getFinishDate());
        return projectEntity;
    }

}

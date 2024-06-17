package com.mas.manageIT.mapper;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.entity.ProjectEntity;
import com.mas.manageIT.model.Order;
import com.mas.manageIT.model.Project;
import com.mas.manageIT.model.ProjectTeam;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class ProjectMapper {

    private static final Logger logger = LoggerFactory.getLogger(ProjectMapper.class);

    public static Project toModel(ProjectEntity projectEntity) {
        Project project = new Project();

        project.setId(projectEntity.getId());
        project.setName(projectEntity.getName());
        project.setDescription(projectEntity.getDescription());
        project.setStartDate(projectEntity.getStartDate());
        project.setFinishDate(projectEntity.getFinishDate());
        addProjectOrderLink(project, projectEntity.getOrder().getId()); //link
        addProjectProjectTeamLink(project, projectEntity.getProjectTeam().getId()); //link
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

    private static void addProjectProjectTeamLink(Project project, Long projectTeamId) {
        try {
            List<ProjectTeam> ptExtent = (List<ProjectTeam>) ObjectPlus.getExtent(ProjectTeam.class);
            Optional<ProjectTeam> thePT = ptExtent.stream()
                    .filter(pt -> pt.getId().equals(projectTeamId))
                    .findFirst();
            if (thePT.isPresent()){
                project.addLink("ProjectProjectTeam", "ProjectTeamProject", thePT.get());
            } else {
                logger.error(() -> "Getting projectTeam: " + projectTeamId + " from extent failed.");
            }
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Getting projectTeam extent failed.");
        }
    }

    private static void addProjectOrderLink(Project project, Long orderId) {
        try {
            List<Order> orderExtent = (List<Order>) ObjectPlus.getExtent(Order.class);
            Optional<Order> theOrder = orderExtent.stream()
                    .filter(order -> order.getId().equals(orderId))
                    .findFirst();
            if (theOrder.isPresent()){
                project.addLink("ProjectOrder", "OrderProject", theOrder.get());
            } else {
                logger.error(() -> "Getting order: " + orderId + " from extent failed.");
            }
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Getting order's extent failed.");
        }
    }

}

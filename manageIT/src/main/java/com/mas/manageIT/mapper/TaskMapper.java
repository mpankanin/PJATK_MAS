package com.mas.manageIT.mapper;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.entity.TaskEntity;
import com.mas.manageIT.model.Customer;
import com.mas.manageIT.model.Project;
import com.mas.manageIT.model.Task;
import com.mas.manageIT.model.TeamMember;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class TaskMapper {

    private static final Logger logger = LoggerFactory.getLogger(TaskMapper.class);


    public static Task toModel(TaskEntity taskEntity){
        Task task = new Task();

        task.setId(taskEntity.getId());
        task.setDescription(taskEntity.getDescription());
        task.setTaskType(taskEntity.getTaskType());
        task.setStartDate(taskEntity.getStartDate());
        task.setFinishDate(taskEntity.getFinishDate());
        addTaskTeamMemberLink(task, taskEntity.getAssignee().getId()); //link
        addTaskProjectLink(task, taskEntity.getProject().getId()); //link
        return task;
    }

    public static TaskEntity toEntity(Task task){
        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setId(task.getId());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setTaskType(task.getTaskType());
        taskEntity.setStartDate(task.getStartDate());
        taskEntity.setFinishDate(task.getFinishDate());
        return taskEntity;
    }

    private static void addTaskProjectLink(Task task, Long projectId) {
        try {
            List<Project> projectExtent = (List<Project>) ObjectPlus.getExtent(Project.class);
            Optional<Project> theProject = projectExtent.stream()
                    .filter(project -> project.getId().equals(projectId))
                    .findFirst();
            if (theProject.isPresent()){
                task.addLink("TaskProject", "ProjectTask", theProject.get());
            } else {
                logger.error(() -> "Getting project: " + projectId + " from extent failed.");
            }
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Getting project's extent failed.");
        }
    }

    private static void addTaskTeamMemberLink(Task task, Long teamMemberId) {
        try {
            List<TeamMember> teamMemberExtent = (List<TeamMember>) ObjectPlus.getExtent(TeamMember.class);
            Optional<TeamMember> theTM = teamMemberExtent.stream()
                    .filter(tm -> tm.getId().equals(teamMemberId))
                    .findFirst();
            if (theTM.isPresent()){
                task.addLink("TaskTeamMember", "TeamMemberTask", theTM.get());
            } else {
                logger.error(() -> "Getting team member: " + teamMemberId + " from extent failed.");
            }
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Getting team member's extent failed.");
        }
    }

}

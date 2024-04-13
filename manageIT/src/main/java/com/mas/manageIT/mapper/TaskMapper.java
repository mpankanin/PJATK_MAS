package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.TaskEntity;
import com.mas.manageIT.model.Task;

public class TaskMapper {

    public static Task toModel(TaskEntity taskEntity){
        Task task = new Task();
        task.setId(taskEntity.getId());
        task.setDescription(taskEntity.getDescription());
        task.setTaskType(taskEntity.getTaskType());
        task.setStartDate(taskEntity.getStartDate());
        task.setFinishDate(taskEntity.getFinishDate());
        task.setProject(ProjectMapper.toModel(taskEntity.getProject()));
        task.setAssignee(EmployerMapper.toModel(taskEntity.getAssignee()));
        task.setAssigner(EmployerMapper.toModel(taskEntity.getAssigner()));
        return task;
    }

    public static TaskEntity toEntity(Task task){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(task.getId());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setTaskType(task.getTaskType());
        taskEntity.setStartDate(task.getStartDate());
        taskEntity.setFinishDate(task.getFinishDate());
        taskEntity.setProject(ProjectMapper.toEntity(task.getProject()));
        taskEntity.setAssignee(EmployerMapper.toEntity(task.getAssignee()));
        taskEntity.setAssigner(EmployerMapper.toEntity(task.getAssigner()));
        return taskEntity;
    }

}

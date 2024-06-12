package com.mas.manageIT.model;

import com.mas.manageIT.exception.AssociationException;
import com.mas.manageIT.model.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Long id;

    private String description;

    private TaskType taskType;

    private LocalDate startDate;

    private LocalDate finishDate;

    private Project project;

    private TeamMember assignee;


    //qualified association - second side
    public void addProject(Project project) {
        if(this.project == null){
            this.project = project;

            //primary connection
            project.addTaskQualified(this);
        } else if(!this.project.equals(project)){
            throw new AssociationException("The association already exist.");
        }
    }

    //qualified association - second side
    public void removeProject(Project project) {
        if(this.project.equals(project)) {
            this.project = null;

            //primary connection
            project.removeTaskQualified(this);
        }
    }

}

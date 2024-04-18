package com.mas.manageIT.model;

import com.mas.manageIT.exception.AssociationException;
import com.mas.manageIT.model.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @NonNull
    private Long id;

    @NonNull
    @Size(max = 200)
    private String description;

    @NonNull
    private TaskType taskType;

    @NonNull
    private LocalDate startDate;

    @Nullable
    private LocalDate finishDate;

    //qualified association
    private Project project;

    private Employer assigner;

    private Employer assignee;



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

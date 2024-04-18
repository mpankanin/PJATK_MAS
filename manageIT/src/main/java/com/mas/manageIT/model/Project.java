package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Size(min = 3, max = 200)
    private String description;

    @NonNull
    private LocalDate startDate;

    @NonNull
    private LocalDate finishDate;

    private Order order;

    //plain association
    private ProjectTeam projectTeam;

    private List<Task> tasks;

    //qualified association
    private Map<Long, Task> tasksQualified = new TreeMap<>();



    //qualified association - add
    public void addTaskQualified(Task task){
        if(!tasksQualified.containsKey(task.getId())){
            tasksQualified.put(task.getId(), task);

            //reverse connection
            task.addProject(this);
        }
    }

    //qualified association - remove
    public void removeTaskQualified(Task task){
        if(tasksQualified.containsKey(task.getId())){
            tasksQualified.remove(task.getId());

            //reverse connection
            task.removeProject(this);
        }
    }

    //qualified association - find
    public Task findTaskQualified(Long id) throws Exception{
        if(!tasksQualified.containsKey(id)){
            throw new Exception("Order not found: " + id);
        }

        return tasksQualified.get(id);
    }

}

package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    public Project(Long id, String name, String description, LocalDate startDate, LocalDate finishDate, Order order) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.order = order;
    }



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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (!id.equals(project.id)) return false;
        if (!name.equals(project.name)) return false;
        if (!description.equals(project.description)) return false;
        if (!startDate.equals(project.startDate)) return false;
        if (!finishDate.equals(project.finishDate)) return false;
        return Objects.equals(tasksQualified, project.tasksQualified);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + finishDate.hashCode();
        return result;
    }

}

package com.mas.manageIT.model;

import com.mas.manageIT.associacionsManager.ObjectPlusPlus;
import com.mas.manageIT.model.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Task extends ObjectPlusPlus {

    private Long id;

    private String description;

    private TaskType taskType;

    private LocalDate startDate;

    private LocalDate finishDate;

    private Project project;

    private TeamMember assignee;

    private static List<Task> extent = new ArrayList<>();


    public static void addTask(Task task){
        extent.add(task);
    }

    public static void removeTask(Task task){
        extent.remove(task);
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + Task.class.getName());
        for (Task task : extent){
            System.out.println(task);
        }
    }

}

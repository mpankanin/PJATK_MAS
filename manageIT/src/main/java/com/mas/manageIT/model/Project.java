package com.mas.manageIT.model;

import com.mas.manageIT.associacionsManager.ObjectPlusPlus;
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
public class Project extends ObjectPlusPlus {

    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate finishDate;

    private ProjectTeam projectTeam;

    private Order order;

    private List<Task> tasks;

    private static List<Project> extent = new ArrayList<>();


    public static void addProject(Project project){
        extent.add(project);
    }

    public static void removeProject(Project project){
        extent.remove(project);
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + Project.class.getName());
        for (Project project : extent){
            System.out.println(project);
        }
    }

}

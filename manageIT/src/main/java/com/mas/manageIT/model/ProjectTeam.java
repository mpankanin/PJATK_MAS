package com.mas.manageIT.model;

import com.mas.manageIT.associacionsManager.ObjectPlusPlus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProjectTeam extends ObjectPlusPlus {

    private Long id;

    private String name;

    private static int maxEmployers = 10;

    private TeamMember teamLeader;

    private TeamMember[] teamMembers = new TeamMember[maxEmployers];

    private List<Project> projects;

    private static List<ProjectTeam> extent = new ArrayList<>();


    public static void addProjectTeam(ProjectTeam projectTeam){
        extent.add(projectTeam);
    }

    public static void removeProjectTeam(ProjectTeam projectTeam){
        extent.remove(projectTeam);
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + ProjectTeam.class.getName());
        for (ProjectTeam projectTeam : extent){
            System.out.println(projectTeam);
        }
    }

}

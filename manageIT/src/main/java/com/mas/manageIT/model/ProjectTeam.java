package com.mas.manageIT.model;

import java.util.List;

public class ProjectTeam {

    private Long id;
    private Employer teamLeader;
    private Employer[] teamMembers;
    private List<Project> projects;

    //class attribute
    private static Integer maxEmployers = 10;


}

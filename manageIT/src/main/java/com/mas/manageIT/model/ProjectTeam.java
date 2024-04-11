package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTeam {

    private Long id;
    private Employer teamLeader;
    private Employer[] teamMembers;
    private List<Project> projects;

    //class attribute
    private static Integer maxEmployers = 10;


}

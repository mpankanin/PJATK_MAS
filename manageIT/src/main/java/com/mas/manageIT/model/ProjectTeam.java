package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTeam {

    @NonNull
    private Long id;

    @NonNull
    private Employer teamLeader;

    @NonNull
    private Employer[] teamMembers = new Employer[maxEmployers];

    @Nullable
    private List<Project> projects;

    //class attribute
    private static Integer maxEmployers = 10;

}

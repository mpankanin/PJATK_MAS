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
    private String name;

    @Nullable
    private List<Project> projects;

    @NonNull
    private Employer[] teamMembers = new Employer[maxEmployers];

    @NonNull
    private Employer teamLeader;

    //class attribute
    private static Integer maxEmployers = 10;

    public Integer getMaxEmployers() {
        return maxEmployers;
    }

    public void setMaxEmployers(Integer maxEmployers) {
        ProjectTeam.maxEmployers = maxEmployers;
    }

}

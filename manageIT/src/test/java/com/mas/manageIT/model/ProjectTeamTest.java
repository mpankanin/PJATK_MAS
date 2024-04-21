package com.mas.manageIT.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTeamTest {

    @Test
    void getMaxEmployers() {
        // given
        ProjectTeam projectTeam1 = new ProjectTeam();
        ProjectTeam projectTeam2 = new ProjectTeam();

        // when
        int maxEmployers1 = projectTeam1.getTeamMembers().length;
        int maxEmployers2 = projectTeam2.getTeamMembers().length;

        // then
        assertEquals(maxEmployers1, maxEmployers2);
    }

    @Test
    void should_create_plain_association_ProjectTeam_Project() {
        // given
        ProjectTeam projectTeam = new ProjectTeam();

        Project project = new Project();
        Project project2 = new Project();

        List<Project> projects = new ArrayList<>();

        // when
        projectTeam.setProjects(projects);

        // then
        assertEquals(projects, projectTeam.getProjects());
    }

}
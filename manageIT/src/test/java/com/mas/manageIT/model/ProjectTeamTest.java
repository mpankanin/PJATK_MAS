package com.mas.manageIT.model;

import org.junit.jupiter.api.Test;

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

}
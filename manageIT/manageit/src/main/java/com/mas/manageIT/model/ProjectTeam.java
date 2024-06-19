package com.mas.manageIT.model;

import com.mas.manageIT.associacion_manager.ObjectPlusPlus;
import com.mas.manageIT.exception.AssociationException;
import com.mas.manageIT.model.enums.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProjectTeam extends ObjectPlusPlus {

    private Long id;

    private String name;

    private static int maxEmployers = 10;


    public void assignTeamLeader(TeamMember teamMember){
        try {
            ObjectPlusPlus[] links = teamMember.getLinks("TeamMemberProjectTeam");
            ProjectTeam projectTeam = (ProjectTeam) links[0];

            ObjectPlusPlus[] tmLinks = projectTeam.getLinks("ProjectTeamTeamMember");
            if(tmLinks.length >= maxEmployers) {
                throw new AssociationException("The project team: " + projectTeam.getId() + " is full.");
            }
            List<TeamMember> teamMembers = Arrays.stream(tmLinks).map(tm -> (TeamMember) tm).toList();
            Optional<TeamMember> optional = teamMembers.stream().filter(tm -> tm.getRole().equals(MemberRole.TEAM_LEADER)).findFirst();
            if (optional.isPresent()){
                throw new AssociationException("The project team can have only one team leader.");
            }
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(TeamMember.class);
            logger.error(() -> "Getting project team's extent failed.");
        }

        if (teamMember.getRole().equals(MemberRole.TEAM_LEADER)){
            teamMember.addLink("TeamMemberProjectTeam", "ProjectTeamTeamMember", this);
        } else {
            throw new AssociationException("The employer must has a Team Leader role.");
        }
    }

}

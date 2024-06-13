package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.TeamMemberEntity;
import com.mas.manageIT.model.TeamMember;

public class TeamMemberMapper {

    public static TeamMember toModel(TeamMemberEntity teamMemberEntity) {
        TeamMember teamMember = new TeamMember();

        teamMember.setId(teamMemberEntity.getId());
        teamMember.setFirstName(teamMemberEntity.getFirstName());
        teamMember.setLastName(teamMemberEntity.getLastName());
        teamMember.setBirthDate(teamMemberEntity.getBirthDate());
        teamMember.setEmail(teamMemberEntity.getEmail());
        teamMember.setPhoneNumber(teamMemberEntity.getPhoneNumber());
        teamMember.setCorrespondenceAddress(teamMemberEntity.getCorrespondenceAddress());
        teamMember.setIsArmyMember(teamMemberEntity.getIsArmyMember());
        teamMember.setMaidenName(teamMemberEntity.getMaidenName());
        teamMember.setIsPregnant(teamMemberEntity.getIsPregnant());
        teamMember.setHireDate(teamMemberEntity.getHireDate());
        teamMember.setReleaseDate(teamMemberEntity.getReleaseDate());
        teamMember.setSalary(teamMemberEntity.getSalary());
        teamMember.setBonus(teamMemberEntity.getBonus());
        teamMember.setRole(teamMemberEntity.getRole());
        teamMember.setMbaDate(teamMemberEntity.getMbaDate());
        return teamMember;
    }

    public static TeamMemberEntity toEntity(TeamMember teamMember) {
        TeamMemberEntity teamMemberEntity = new TeamMemberEntity();

        teamMemberEntity.setId(teamMember.getId());
        teamMemberEntity.setFirstName(teamMember.getFirstName());
        teamMemberEntity.setLastName(teamMember.getLastName());
        teamMemberEntity.setBirthDate(teamMember.getBirthDate());
        teamMemberEntity.setEmail(teamMember.getEmail());
        teamMemberEntity.setPhoneNumber(teamMember.getPhoneNumber());
        teamMemberEntity.setCorrespondenceAddress(teamMember.getCorrespondenceAddress());
        teamMemberEntity.setIsArmyMember(teamMember.getIsArmyMember());
        teamMemberEntity.setMaidenName(teamMember.getMaidenName());
        teamMemberEntity.setIsPregnant(teamMember.getIsPregnant());
        teamMemberEntity.setHireDate(teamMember.getHireDate());
        teamMemberEntity.setReleaseDate(teamMember.getReleaseDate());
        teamMemberEntity.setSalary(teamMember.getSalary());
        teamMemberEntity.setBonus(teamMember.getBonus());
        teamMemberEntity.setRole(teamMember.getRole());
        teamMemberEntity.setMbaDate(teamMember.getMbaDate());
        return teamMemberEntity;
    }

}

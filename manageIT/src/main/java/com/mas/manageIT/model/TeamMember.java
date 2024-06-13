package com.mas.manageIT.model;

import com.mas.manageIT.model.enums.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TeamMember extends Employer{

    private MemberRole role;

    private LocalDate mbaDate;

    private List<Task> tasks;

    private List<Resource> resources;

    private Warehouse warehouse;


    @Override
    public String getType() {
        return TeamMember.class.getName();
    }

    @Override
    public Boolean isMale() {
        return super.getIsArmyMember() != null && super.getIsArmyMember();
    }

}

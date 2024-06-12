package com.mas.manageIT.entity;

import com.mas.manageIT.model.enums.MemberRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "TEAM_MEMBER")
public class TeamMemberEntity extends EmployerEntity{

    @Column(name = "ROLE")
    private MemberRole role;

    @Column(name = "MBA_AQUSITION_DATE")
    private LocalDate mbaDate;

    @OneToMany(mappedBy = "assignee")
    private List<TaskEntity> tasks;

    @OneToMany(mappedBy = "assignee")
    private List<ResourceEntity> resources;

    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_ID")
    private WarehouseEntity warehouse;

}

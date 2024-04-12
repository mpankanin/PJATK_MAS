package com.mas.manageIT.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PROJECT_TEAM")
public class ProjectTeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @OneToMany(mappedBy = "projectTeam")
    private List<OrderEntity> orders;

    @OneToMany(mappedBy = "projectTeam")
    private List<ProjectEntity> projects;

    @OneToMany(mappedBy = "projectTeam")
    private List<EmployerEntity> teamMembers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_leader_id", referencedColumnName = "id")
    private EmployerEntity teamLeader;

}

package com.mas.manageIT.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "EMPLOYER")
public class EmployerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "COMPANY", nullable = false)
    private String company;

    @Column(name = "CORRESPONDENCE_ADDRESS", nullable = false)
    private String correspondenceAddress;

    @ManyToOne
    private ProjectTeamEntity projectTeam;

    @OneToMany(mappedBy = "assignee")
    private List<ResourceEntity> resources;

    @OneToMany(mappedBy = "assignee")
    private List<TaskEntity> tasks;

    @OneToMany(mappedBy = "assigner")
    private List<TaskEntity> delegatedTasks;

}

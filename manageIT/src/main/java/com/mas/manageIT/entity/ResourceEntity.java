package com.mas.manageIT.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "RESOURCE")
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "START_DATE", nullable = false)
    private String startDate;

    @Column(name = "FINISH_DATE", nullable = false)
    private String finishDate;

    private EmployerEntity resourceManager;
    private EmployerEntity projectManager;
    private CustomerEntity customer;
    private ProjectTeamEntity projectTeam;
    private ProjectEntity project;
    private List<TaskEntity> tasks;
}

package com.mas.manageIT.entity;

import com.mas.manageIT.model.enums.TaskType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TASK")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TASK_TYPE")
    private TaskType taskType;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "FINISH_DATE")
    private LocalDate finishDate;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private ProjectEntity project;

    @ManyToOne
    @JoinColumn(name = "TEAM_MEMBER_ID")
    private TeamMemberEntity assignee;

}

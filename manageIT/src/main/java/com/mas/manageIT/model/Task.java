package com.mas.manageIT.model;

import com.mas.manageIT.model.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Task {

    private Long id;

    private String description;

    private TaskType taskType;

    private LocalDate startDate;

    private LocalDate finishDate;

    private Project project;

    private TeamMember assignee;

}

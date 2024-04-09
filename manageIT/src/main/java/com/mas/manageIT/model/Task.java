package com.mas.manageIT.model;

import com.mas.manageIT.model.enums.TaskType;

import java.time.LocalDate;

public class Task {

    private Long id;
    private String description;
    private TaskType taskType;
    private LocalDate startDate;
    private LocalDate finishDate;
    private Project project;
    private Employer assigner;
    private Employer assignee;

}

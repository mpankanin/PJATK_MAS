package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Project {

    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate finishDate;

    private ProjectTeam projectTeam;

    private Order order;

    private List<Task> tasks;

}

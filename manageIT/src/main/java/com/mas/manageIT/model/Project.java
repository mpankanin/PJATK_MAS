package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private Long id;
    private String description;
    private Order order;
    private ProjectTeam projectTeam;
    private List<Task> taskList;
    private List<Resource> resourceList;

}

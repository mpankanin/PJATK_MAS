package com.mas.manageIT.model;

import java.util.List;

public class Project {

    private Long id;
    private String description;
    private Order order;
    private ProjectTeam projectTeam;
    private List<Task> taskList;
    private List<Resource> resourceList;

}

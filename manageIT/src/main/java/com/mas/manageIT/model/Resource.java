package com.mas.manageIT.model;

import com.mas.manageIT.model.enums.ResourceState;
import com.mas.manageIT.model.enums.ResourceType;

import java.time.LocalDate;

public class Resource {

    private Long id;
    private ResourceType resourceType;
    private ResourceState resourceState;
    private LocalDate purchaseDate;
    private Employer dutyHolder;
    private Employer assignee;
    private Project project;

}

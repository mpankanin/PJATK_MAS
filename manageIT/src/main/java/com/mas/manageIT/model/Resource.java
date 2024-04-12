package com.mas.manageIT.model;

import com.mas.manageIT.model.enums.ResourceState;
import com.mas.manageIT.model.enums.ResourceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {

    private Long id;

    private ResourceType resourceType;

    private ResourceState resourceState;

    private LocalDate purchaseDate;

    private Employer careTaker;

    private Employer assignee;

    private Project project;

}

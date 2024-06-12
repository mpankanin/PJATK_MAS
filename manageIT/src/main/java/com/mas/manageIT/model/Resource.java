package com.mas.manageIT.model;

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

    private String name;

    private ResourceType resourceType;

    private LocalDate purchaseDate;

    private TeamMember assignee;

    private Warehouse warehouse;

}

package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @NonNull
    private Long id;

    @NonNull
    @Size(min = 3, max = 200)
    private String description;

    @NonNull
    private Order order;

    @NonNull
    private ProjectTeam projectTeam;

    private List<Task> taskList;

    private List<Resource> resourceList;

}

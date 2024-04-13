package com.mas.manageIT.model;

import com.mas.manageIT.model.enums.ResourceState;
import com.mas.manageIT.model.enums.ResourceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resource {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private ResourceType resourceType;

    @NonNull
    private ResourceState resourceState;

    @NonNull
    private LocalDate purchaseDate;

    @NonNull
    private Employer careTaker;

    @Nullable
    private Employer assignee;

}

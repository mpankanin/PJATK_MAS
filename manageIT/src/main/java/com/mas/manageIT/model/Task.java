package com.mas.manageIT.model;

import com.mas.manageIT.model.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @NonNull
    private Long id;

    @NonNull
    @Size(max = 200)
    private String description;

    @NonNull
    private TaskType taskType;

    @NonNull
    private LocalDate startDate;

    @Nullable
    private LocalDate finishDate;

    @NonNull
    private Project project;

    @NonNull
    private Employer assigner;

    @NonNull
    private Employer assignee;

}

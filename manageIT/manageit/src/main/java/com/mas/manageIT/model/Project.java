package com.mas.manageIT.model;

import com.mas.manageIT.associacion_manager.ObjectPlusPlus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Project extends ObjectPlusPlus {

    private Long id;

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate finishDate;

}

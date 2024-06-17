package com.mas.manageIT.model;

import com.mas.manageIT.associacion_manager.ObjectPlusPlus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProjectTeam extends ObjectPlusPlus {

    private Long id;

    private String name;

    private static int maxEmployers = 10;

}

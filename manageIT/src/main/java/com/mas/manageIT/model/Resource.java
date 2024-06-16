package com.mas.manageIT.model;

import com.mas.manageIT.associacionsManager.ObjectPlusPlus;
import com.mas.manageIT.model.enums.ResourceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Resource extends ObjectPlusPlus {

    private Long id;

    private String name;

    private ResourceType resourceType;

    private LocalDate purchaseDate;

    private TeamMember assignee;

    private Warehouse warehouse;

    private static List<Resource> extent = new ArrayList<>();


    public static void addResource(Resource resource){
        extent.add(resource);
    }

    public static void removeResource(Resource resource){
        extent.remove(resource);
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + Resource.class.getName());
        for (Resource resource : extent){
            System.out.println(resource);
        }
    }

}

package com.mas.manageIT.model;

import com.mas.manageIT.associacionsManager.ObjectPlusPlus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Warehouse extends ObjectPlusPlus {

    private Long id;

    private String name;

    private String address;

    private WarehouseManager warehouseManager;

    private List<Resource> storedResources;

    private static List<Warehouse> extent = new ArrayList<>();


    public static void addWarehouse(Warehouse warehouse){
        extent.add(warehouse);
    }

    public static void removeWarehouse(Warehouse warehouse){
        extent.remove(warehouse);
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + Warehouse.class.getName());
        for (Warehouse warehouse : extent){
            System.out.println(warehouse);
        }
    }

}

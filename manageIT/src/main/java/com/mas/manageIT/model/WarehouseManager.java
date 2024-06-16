package com.mas.manageIT.model;

import com.mas.manageIT.entity.EmployerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WarehouseManager extends EmployerEntity {

    private LocalDate forkliftLicense;

    private Warehouse warehouse;

    private static List<WarehouseManager> extent = new ArrayList<>();


    public static void addWarehouseManager(WarehouseManager warehouseManager){
        extent.add(warehouseManager);
    }

    public static void removeWarehouseManager(WarehouseManager warehouseManager){
        extent.remove(warehouseManager);
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + WarehouseManager.class.getName());
        for (WarehouseManager warehouseManager : extent){
            System.out.println(warehouseManager);
        }
    }

}

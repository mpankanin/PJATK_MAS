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
public class Warehouse extends ObjectPlusPlus {

    private Long id;

    private String name;

    private String address;


    public void assign(WarehouseManager warehouseManager){
        warehouseManager.addLink("WarehouseManagerWarehouse", "WarehouseWarehouseManager", this);
    }

}

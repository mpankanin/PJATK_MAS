package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.WarehouseEntity;
import com.mas.manageIT.model.Warehouse;

public class WarehouseMapper {

    public static Warehouse toModel(WarehouseEntity warehouseEntity) {
        Warehouse warehouse = new Warehouse();

        warehouse.setId(warehouseEntity.getId());
        warehouse.setName(warehouseEntity.getName());
        warehouse.setAddress(warehouseEntity.getAddress());
        return warehouse;
    }

    public static WarehouseEntity toEntity(Warehouse warehouse){
        WarehouseEntity warehouseEntity = new WarehouseEntity();

        warehouseEntity.setId(warehouse.getId());
        warehouseEntity.setName(warehouse.getName());
        warehouseEntity.setAddress(warehouse.getAddress());
        return warehouseEntity;
    }

}

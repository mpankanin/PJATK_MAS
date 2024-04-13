package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.WarehouseEntity;
import com.mas.manageIT.model.Warehouse;

import java.util.stream.Collectors;

public class WarehouseMapper {

    public static Warehouse toModel(WarehouseEntity warehouseEntity) {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseEntity.getId());
        warehouse.setName(warehouseEntity.getName());
        warehouse.setAddress(warehouseEntity.getAddress());
        warehouse.setStoredResources(warehouseEntity.getStoredResources().stream().map(ResourceMapper::toModel).collect(Collectors.toList()));
        warehouse.setWarehouseManager(EmployerMapper.toModel(warehouseEntity.getWarehouseManager()));
        return warehouse;
    }

    public static WarehouseEntity toEntity(Warehouse warehouse){
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setId(warehouse.getId());
        warehouseEntity.setName(warehouse.getName());
        warehouseEntity.setAddress(warehouse.getAddress());
        warehouseEntity.setStoredResources(warehouse.getStoredResources().stream().map(ResourceMapper::toEntity).collect(Collectors.toList()));
        warehouseEntity.setWarehouseManager(EmployerMapper.toEntity(warehouse.getWarehouseManager()));
        return warehouseEntity;
    }

}

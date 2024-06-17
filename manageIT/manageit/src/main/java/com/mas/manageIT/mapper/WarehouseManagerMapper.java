package com.mas.manageIT.mapper;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.entity.WarehouseManagerEntity;
import com.mas.manageIT.model.Warehouse;
import com.mas.manageIT.model.WarehouseManager;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class WarehouseManagerMapper {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseManager.class);


    public static WarehouseManager toModel(WarehouseManagerEntity warehouseManagerEntity){
        WarehouseManager warehouseManager = new WarehouseManager();

        warehouseManager.setId(warehouseManagerEntity.getId());
        warehouseManager.setFirstName(warehouseManagerEntity.getFirstName());
        warehouseManager.setLastName(warehouseManagerEntity.getLastName());
        warehouseManager.setBirthDate(warehouseManagerEntity.getBirthDate());
        warehouseManager.setEmail(warehouseManagerEntity.getEmail());
        warehouseManager.setPhoneNumber(warehouseManagerEntity.getPhoneNumber());
        warehouseManager.setCorrespondenceAddress(warehouseManagerEntity.getCorrespondenceAddress());
        warehouseManager.setIsArmyMember(warehouseManagerEntity.getIsArmyMember());
        warehouseManager.setMaidenName(warehouseManagerEntity.getMaidenName());
        warehouseManager.setIsPregnant(warehouseManagerEntity.getIsPregnant());
        warehouseManager.setHireDate(warehouseManagerEntity.getHireDate());
        warehouseManager.setReleaseDate(warehouseManagerEntity.getReleaseDate());
        warehouseManager.setSalary(warehouseManagerEntity.getSalary());
        warehouseManager.setBonus(warehouseManagerEntity.getBonus());
        warehouseManager.setForkliftLicense(warehouseManagerEntity.getForkliftLicense());
        addWarehouseManagerWarehouseLink(warehouseManager, warehouseManagerEntity.getWarehouse().getId()); //link
        return warehouseManager;
    }

    public static WarehouseManagerEntity toEntity(WarehouseManager warehouseManager){
        WarehouseManagerEntity warehouseManagerEntity = new WarehouseManagerEntity();

        warehouseManagerEntity.setId(warehouseManager.getId());
        warehouseManagerEntity.setFirstName(warehouseManager.getFirstName());
        warehouseManagerEntity.setLastName(warehouseManager.getLastName());
        warehouseManagerEntity.setBirthDate(warehouseManager.getBirthDate());
        warehouseManagerEntity.setEmail(warehouseManager.getEmail());
        warehouseManagerEntity.setPhoneNumber(warehouseManager.getPhoneNumber());
        warehouseManagerEntity.setCorrespondenceAddress(warehouseManager.getCorrespondenceAddress());
        warehouseManagerEntity.setIsArmyMember(warehouseManager.getIsArmyMember());
        warehouseManagerEntity.setMaidenName(warehouseManager.getMaidenName());
        warehouseManagerEntity.setIsPregnant(warehouseManager.getIsPregnant());
        warehouseManagerEntity.setHireDate(warehouseManager.getHireDate());
        warehouseManagerEntity.setReleaseDate(warehouseManager.getReleaseDate());
        warehouseManagerEntity.setSalary(warehouseManager.getSalary());
        warehouseManagerEntity.setBonus(warehouseManager.getBonus());
        warehouseManagerEntity.setForkliftLicense(warehouseManager.getForkliftLicense());
        return warehouseManagerEntity;
    }

    private static void addWarehouseManagerWarehouseLink(WarehouseManager warehouseManager, Long warehouseId) {
        try {
            List<Warehouse> warehouseExtent = (List<Warehouse>) ObjectPlus.getExtent(Warehouse.class);
            Optional<Warehouse> theWarehouse = warehouseExtent.stream()
                    .filter(warehouse -> warehouse.getId().equals(warehouseId))
                    .findFirst();
            if (theWarehouse.isPresent()){
                warehouseManager.addLink("WarehouseManagerWarehouse", "WarehouseWarehouseManager", theWarehouse.get());
            } else {
                logger.error(() -> "Getting warehouse: " + warehouseId + " from extent failed.");
            }
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Getting warehouse's extent failed.");
        }
    }

}

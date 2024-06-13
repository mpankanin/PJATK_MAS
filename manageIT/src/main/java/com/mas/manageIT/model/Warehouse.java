package com.mas.manageIT.model;

import com.mas.manageIT.associacionsManager.ObjectPlusPlus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

}

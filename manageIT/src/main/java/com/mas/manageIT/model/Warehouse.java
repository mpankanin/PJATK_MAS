package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Warehouse {

    private Long id;

    private String name;

    private String address;

    private WarehouseManager warehouseManager;

    private List<Resource> storedResources;

}

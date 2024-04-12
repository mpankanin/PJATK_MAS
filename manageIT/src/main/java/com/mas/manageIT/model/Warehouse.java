package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {

    private Long id;

    private String address;

    private List<Resource> storedResources;

    private Employer warehouseManager;

}

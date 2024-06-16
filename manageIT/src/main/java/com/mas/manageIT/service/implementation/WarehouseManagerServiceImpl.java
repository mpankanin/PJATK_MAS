package com.mas.manageIT.service.implementation;

import com.mas.manageIT.repository.WarehouseManagerRepository;
import com.mas.manageIT.service.WarehouseManagerService;
import org.springframework.stereotype.Service;

@Service
public class WarehouseManagerServiceImpl implements WarehouseManagerService {

    private final WarehouseManagerRepository warehouseManagerRepository;


    public WarehouseManagerServiceImpl(WarehouseManagerRepository warehouseManagerRepository) {
        this.warehouseManagerRepository = warehouseManagerRepository;
    }

}

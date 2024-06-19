package com.mas.manageIT.service.implementation;

import com.mas.manageIT.model.WarehouseManager;
import com.mas.manageIT.repository.WarehouseRepository;
import com.mas.manageIT.service.WarehouseService;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

}

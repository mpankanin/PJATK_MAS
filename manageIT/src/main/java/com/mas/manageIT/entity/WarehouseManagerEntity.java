package com.mas.manageIT.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "WAREHOUSE_MANAGER")
public class WarehouseManagerEntity extends EmployerEntity{

    @Column(name = "FORKLIFT_LICENSE")
    private LocalDate forkliftLicense;

    @OneToOne
    @JoinColumn(name = "WAREHOUSE_ID")
    private WarehouseEntity warehouse;

}

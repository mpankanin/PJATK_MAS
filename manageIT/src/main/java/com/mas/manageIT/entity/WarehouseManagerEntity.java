package com.mas.manageIT.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "WAREHOUSE_MANAGER")
public class WarehouseManagerEntity extends EmployerEntity{

    @Column(name = "FORKLIFT_LICENSE")
    private LocalDate forkliftLicense;

    @OneToOne
    @JoinColumn(name = "WAREHOUSE_ID")
    private WarehouseEntity warehouse;

}

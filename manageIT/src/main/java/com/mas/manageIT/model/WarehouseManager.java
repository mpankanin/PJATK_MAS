package com.mas.manageIT.model;

import com.mas.manageIT.entity.EmployerEntity;
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
public class WarehouseManager extends EmployerEntity {

    private LocalDate forkliftLicense;

    private Warehouse warehouse;

}

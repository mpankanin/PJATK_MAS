package com.mas.manageIT.entity;

import com.mas.manageIT.model.enums.ResourceState;
import com.mas.manageIT.model.enums.ResourceType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "RESOURCE")
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RESOURCE_TYPE", nullable = false)
    private ResourceType resourceType;

    @Column(name = "RESOURCE_STATE", nullable = false)
    private ResourceState resourceState;

    @Column(name = "PURCHASE_DATE", nullable = false)
    private LocalDate purchaseDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "care_taker_id", referencedColumnName = "id")
    private EmployerEntity careTaker;

    @ManyToOne
    private EmployerEntity assignee;

    @ManyToOne
    private WarehouseEntity warehouse;

}

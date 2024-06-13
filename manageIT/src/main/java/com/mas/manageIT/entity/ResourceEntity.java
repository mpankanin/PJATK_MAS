package com.mas.manageIT.entity;

import com.mas.manageIT.model.enums.ResourceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@EqualsAndHashCode

@Entity
@Table(name = "RESOURCE")
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "RESOURCE_TYPE")
    private ResourceType resourceType;

    @Column(name = "PURCHASE_DATE")
    private LocalDate purchaseDate;

    @ManyToOne
    @JoinColumn(name = "TEAM_MEMBER_ID")
    private TeamMemberEntity assignee;

    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_ID")
    private WarehouseEntity warehouse;

}

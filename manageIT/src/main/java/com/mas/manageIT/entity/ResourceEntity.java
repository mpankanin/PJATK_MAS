package com.mas.manageIT.entity;

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

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "START_DATE", nullable = false)
    private String startDate;

    @Column(name = "FINISH_DATE", nullable = false)
    private String finishDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "care_taker_id", referencedColumnName = "id")
    private EmployerEntity careTaker;

    @ManyToOne
    private EmployerEntity assignee;

    @ManyToOne
    private WarehouseEntity warehouse;

}

package com.mas.manageIT.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "FINISH_DATE", nullable = false)
    private LocalDate finishDate;

    private List<CustomerEntity> customers;
    private ProjectTeamEntity projectTeam;
    private ProjectEntity project;

}


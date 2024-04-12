package com.mas.manageIT.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "ORDERS")
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

    @Column(name = "STATUS", nullable = false)
    private String status;

    @ManyToOne
    private CustomerEntity customer;

    @ManyToOne
    private ProjectTeamEntity projectTeam;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private ProjectEntity project;

}


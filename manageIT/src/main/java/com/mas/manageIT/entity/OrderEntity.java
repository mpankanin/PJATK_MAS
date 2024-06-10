package com.mas.manageIT.entity;

import com.mas.manageIT.model.enums.PaymentStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "INSERTION_DATE", nullable = false)
    private LocalDate insertionDate;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @Column(name = "PAYMENT_STATUS", nullable = false)
    private PaymentStatus paymentStatus;

    @ManyToOne
    private CustomerEntity customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private ProjectEntity project;

    @OneToMany(mappedBy = "order")
    private List<DocumentEntity> documents;

}


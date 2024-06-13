package com.mas.manageIT.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity extends PersonEntity{

    @Column(name = "COMPANY")
    private String company;

    @ManyToMany(mappedBy = "customers")
    private List<OrderEntity> orders;

}

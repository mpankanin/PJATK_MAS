package com.mas.manageIT.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;

}

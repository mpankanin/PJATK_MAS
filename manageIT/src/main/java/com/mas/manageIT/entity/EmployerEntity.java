package com.mas.manageIT.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@MappedSuperclass
public class EmployerEntity extends PersonEntity{

    @Column(name = "HIRE_DATE")
    private LocalDate hireDate;

    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;

    @Column(name = "SALARY")
    private Double salary;

    @Column(name = "BONUS")
    private Double bonus;

}

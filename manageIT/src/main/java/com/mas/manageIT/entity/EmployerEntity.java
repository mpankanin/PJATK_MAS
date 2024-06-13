package com.mas.manageIT.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
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

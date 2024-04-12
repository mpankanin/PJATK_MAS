package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;

    private Project project;

    private Double price;

    private LocalDate startDate;

    private LocalDate finishDate;

    //repeatable attribute
    private List<Customer> customers;

    private ProjectTeam projectTeam;

    //overloaded method
    public Double getPrice(float vatRate) {
        return price * vatRate;
    }

}

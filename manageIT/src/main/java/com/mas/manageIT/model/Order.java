package com.mas.manageIT.model;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private Long id;
    private Project project;
    private Double price;
    private LocalDate startDate;
    private LocalDate finishDate;

    //repeatable attribute
    private List<Customer> customers;
    private ProjectTeam projectTeam;

}

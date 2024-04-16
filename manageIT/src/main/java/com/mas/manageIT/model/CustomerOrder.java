package com.mas.manageIT.model;

import lombok.Data;

// class to demonstrate a usage of the attribute association
@Data
public class CustomerOrder {

    private Double price;

    private Customer customer;

    private Order order;

    public CustomerOrder(Double price, Customer customer, Order order) {
        this.price = price;
        this.customer = customer;
        this.order = order;
    }

}

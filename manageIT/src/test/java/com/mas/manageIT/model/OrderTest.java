package com.mas.manageIT.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getPrice() {
        // given
        Order order = new Order();
        order.setPrice(1000);

        // when
        int price = order.getPrice();

        // then
        assertEquals(1000, price);
    }

    @Test
    void testGetPrice() {
        // given
        Order order = new Order();
        order.setPrice(1000);

        // when
        double price = order.getPrice(0.23);

        // then
        assertEquals(1230, price);
    }

    @Test
    void getCustomers() {
        // given
        Order order = new Order();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        // when
        order.setCustomers(List.of(customer1, customer2));

        // then
        assertEquals(2, order.getCustomers().size());
    }
}
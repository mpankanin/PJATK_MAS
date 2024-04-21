package com.mas.manageIT.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void addCustomer() {
        // given
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        // when
        // then
        assertEquals(2, Customer.getCustomers().size());
    }

    @Test
    void removeCustomer() {
        // given
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        // when
        Customer.removeCustomer(customer1);

        // then
        assertEquals(1, Customer.getCustomers().size());
    }

    @Test
    void getType() {
        // given
        Customer customer = new Customer();

        // when
        String type = customer.getType();

        // then
        assertEquals("Customer", type);
    }

    @Test
    void should_create_association_with_attribute_Customer_Order() {
        // given
        Customer customer = new Customer(1L, "John", "Doe", "johndoe@gmail.com", "123456789", "Correspondence Address", "Company");
        Order order = new Order(1L, new Project(), 100, LocalDate.now(), new ArrayList<>());

        // when
        customer.addOrderAttr(order, 100.0);

        // then
        assertEquals(1, customer.getCustomerOrders().size());
        assertEquals(1, order.getCustomerOrders().size());
    }

    @Test
    void should_delete_association_with_attribute_Customer_Order() {
        // given
        Customer customer = new Customer(1L, "John", "Doe", "johndoe@gmail.com", "123456789", "Correspondence Address", "Company");
        Order order = new Order(1L, new Project(), 100, LocalDate.now(), new ArrayList<>());

        // when
        customer.addOrderAttr(order, 100.0);
        customer.removeOrderAttr(order);

        // then
        assertEquals(0, customer.getCustomerOrders().size());
        assertEquals(0, order.getCustomerOrders().size());
    }

}
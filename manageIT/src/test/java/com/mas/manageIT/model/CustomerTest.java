package com.mas.manageIT.model;

import org.junit.jupiter.api.Test;

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

}
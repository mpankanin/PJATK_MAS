package test;

import multi_inheritance.Customer;
import multi_inheritance.CustomerSupplier;
import multi_inheritance.Supplier;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiInheritanceTest {

    @Test
    void should_create_Customer() {
        //given
        Customer customer = new Customer("John", "Doe", LocalDate.of(1990, 1, 1), List.of("order1", "order2"));

        //when
        List<String> orders = customer.getOrders();

        //then
        assertEquals(orders.size(), 2);
    }

    @Test
    void should_create_Supplier() {
        //given
        Supplier supplier = new Supplier("John", "Doe", LocalDate.of(1990, 1, 1), List.of("product1", "product2"));

        //when
        List<String> products = supplier.getProducts();

        //then
        assertEquals(products.size(), 2);
    }

    @Test
    void should_create_CustomerSupplier() {
        //given
        CustomerSupplier customerSupplier = new CustomerSupplier("John", "Doe", LocalDate.of(1990, 1, 1), List.of("order1", "order2"), List.of("product1", "product2"));

        //when
        List<String> products = customerSupplier.getProducts();
        List<String> orders = customerSupplier.getOrders();

        //then
        assertEquals(products.size(), 2);
        assertEquals(orders.size(), 2);
    }

}

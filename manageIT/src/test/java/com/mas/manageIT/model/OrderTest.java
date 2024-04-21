package com.mas.manageIT.model;

import com.mas.manageIT.exception.AssociationException;
import com.mas.manageIT.exception.OrderNotFoundException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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

    @Test
    void should_should_add_document_to_order() {
        // given
        Project project = new Project(1L, "name", "description", LocalDate.now(), LocalDate.now(), null);
        Order order = new Order(1L, project, 1000, LocalDate.now(), List.of(new Customer()));

        // when
        order.addDocument(new Document(1L, "name", "description"));

        // then
        assertEquals(1, order.getDocuments().size());
    }

    @Test
    void should_throw_AssociationException_when_adding_document_to_order() {
        // given
        Project project = new Project(1L, "name", "description", LocalDate.now(), LocalDate.now(), null);
        Order order = new Order(1L, project, 1000, LocalDate.now(), List.of(new Customer()));
        Document document = new Document(1L, "name", "description");

        // when
        order.addDocument(document);

        // then
        assertThrows(AssociationException.class, () -> order.addDocument(document));
    }

    @Test
    void should_create_document(){
        // given
        Project project = new Project(1L, "name", "description", LocalDate.now(), LocalDate.now(), null);
        Order order = new Order(1L, project, 1000, LocalDate.now(), List.of(new Customer()));

        // when
        Document document = Document.createDocument(1L, "name", "description", order);

        // then
        assertEquals(1, order.getDocuments().size());
    }

    @Test
    void should_throw_OrderNotFoundException_when_creating_document(){
        // given
        Project project = new Project(1L, "name", "description", LocalDate.now(), LocalDate.now(), null);
        Order order = new Order(1L, project, 1000, LocalDate.now(), List.of(new Customer()));

        // when
        // then
        assertThrows(OrderNotFoundException.class, () -> Document.createDocument(1L, "name", "description", null));
    }

}
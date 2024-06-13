package com.mas.manageIT.model;

import com.mas.manageIT.associacionsManager.ObjectPlusPlus;
import com.mas.manageIT.model.enums.PaymentStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Order extends ObjectPlusPlus {

    private Long id;

    private LocalDate insertionDate;

    private Double price;

    private PaymentStatus paymentStatus;

    private Customer customer;

    private Project project;

    private List<Document> documents;


    private static List<Order> extent = new ArrayList<>();
    private static List<Document> allDocuments = new ArrayList<>();

    public Order(Long id, LocalDate insertionDate, Double price, PaymentStatus paymentStatus, Customer customer, Project project) {
        this.id = id;
        this.insertionDate = insertionDate;
        this.price = price;
        this.paymentStatus = paymentStatus;
        this.customer = customer;
        this.project = project;
        this.documents = new ArrayList<>();
        addOrder(this);
    }

    public static void addOrder(Order order){
        extent.add(order);
    }

    public static void removeOrder(Order order){
        extent.remove(order);
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + Order.class.getName());
        for (Order order : extent){
            System.out.println(order);
        }
    }

    public void addDocument(Document document) throws IllegalArgumentException{
        if (!documents.contains(document)) {
            if (allDocuments.contains(document)) {
                throw new IllegalArgumentException("Document already added to another order");
            }
            documents.add(document);
            allDocuments.add(document);
        }
    }

    public void removeDocument(Document document){
        documents.remove(document);
        document.setOrder(null);
        Document.removeDocument(document);
    }

}

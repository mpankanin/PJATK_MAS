package com.mas.manageIT.model;

import com.mas.manageIT.associacionsManager.ObjectPlusPlus;
import com.mas.manageIT.model.enums.DocumentType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Document extends ObjectPlusPlus {

    private Long id;

    private DocumentType type;

    private String description;

    private Order order;

    private static List<Document> extent = new ArrayList<>();


    private Document(Long id, DocumentType type, String description, Order order) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.order = order;
    }

    public static Document createDocument(Long id, DocumentType type, String description, Order order) throws IllegalArgumentException{
        if (order == null)
            throw new IllegalArgumentException("Order cannot be null");
        Document document = new Document(id, type, description, order);
        addDocument(document);
        order.addDocument(document);
        return document;
    }

    public static void addDocument(Document document){
        extent.add(document);
    }

    public static void removeDocument(Document document){
        extent.remove(document);
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + Document.class.getName());
        for (Document document : extent){
            System.out.println(document);
        }
    }

}

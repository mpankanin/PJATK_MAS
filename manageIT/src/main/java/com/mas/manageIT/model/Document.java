package com.mas.manageIT.model;

import com.mas.manageIT.exception.OrderNotFoundException;
import lombok.Data;

@Data
public class Document {

    private Long id;

    private String name;

    private String description;

    //association - composition
    private Order order;

    private Document(Long id, Order order, String name, String description){
        this.id = id;
        this.order = order;
        this.name = name;
        this.description = description;
    }

    //composition - adding whole
    public static Document createDocument(Long id, Order order, String name, String description){
        if(order == null){
            throw new OrderNotFoundException("Provided order cannot be null.");
        }
        //creating part
        Document document = new Document(id, order, name, description);

        //adding part to the whole
        order.addDocument(document);

        return document;
    }

}

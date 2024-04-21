package com.mas.manageIT.model;

import com.mas.manageIT.exception.OrderNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Document {

    private Long id;

    private String name;

    private String description;

    //association - composition
    private Order order;

    public Document(Long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    //composition - adding whole
    public static Document createDocument(Long id, String name, String description, Order order){
        if(order == null){
            throw new OrderNotFoundException("Provided order cannot be null.");
        }
        //creating part
        Document document = new Document(id, name, description, order);

        //adding part to the whole
        order.addDocument(document);

        return document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (!Objects.equals(id, document.id)) return false;
        if (!Objects.equals(name, document.name)) return false;
        return Objects.equals(order, document.order);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

}

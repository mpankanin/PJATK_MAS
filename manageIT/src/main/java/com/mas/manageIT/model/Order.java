package com.mas.manageIT.model;

import com.mas.manageIT.Exception.AssociationException;
import com.mas.manageIT.Exception.OrderNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @NonNull
    private Long id;

    @NonNull
    private Project project;

    @NonNull
    private Integer price;

    @NonNull
    private LocalDate insertionDate;

    //repeatable attribute
    //qualified association - second side
    private List<Customer> customers;

    //association with an attribute
    private List<CustomerOrder> customerOrders;

    //association - composition
    private List<Document> documents = new ArrayList<>();
    private Set<Document> allDocuments = new HashSet<>();

    //composition adding part
    public void addDocument(Document document) throws AssociationException {
        if(!documents.contains(document)){
            if(allDocuments.contains(document)){
                throw new AssociationException("Composition - the part is already connected with a whole.");
            }
            documents.add(document);

            //adding document to control association rules
            allDocuments.add(document);
        }
    }

    //overloaded method
    public Double getPrice(double vatRate) {
        return price + price * vatRate;
    }

    //qualified association - second side
    public void addCustomer(Customer customer) {
        if(!customers.contains(customer)) {
            customers.add(customer);

            //primary connection
            customer.addOrderQualified(this);
        }
    }

    //qualified association - second side
    public void removeCustomer(Customer customer) {
        if(customers.contains(customer)) {
            customers.remove(customer);

            //primary connection
            customer.removeOrderQualified(this);
        }
    }

    //add association with an attribute
    public void addCustomerAttr(Customer customer, Double price){
        for(CustomerOrder customerOrder : customerOrders){
            if(customerOrder.getCustomer().equals(customer)){
                return;
            }
        }
        customerOrders.add(new CustomerOrder(price, customer, this));
    }

    //remove association with an attribute
    public void removeCustomerAttr(Customer customer){
        customerOrders.removeIf(customerOrder -> customerOrder.getCustomer().equals(customer));
    }

    public String compositionToString(){
        StringBuilder compositionInfo = new StringBuilder("Whole: " + this.getClass().getName() + '\n');
        for (Document document : documents){
            compositionInfo.append(document.getId() + '\n');
        }
        return compositionInfo.toString();
    }

}

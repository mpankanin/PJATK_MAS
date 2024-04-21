package com.mas.manageIT.model;

import com.mas.manageIT.exception.AssociationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
    private List<Customer> customers = new ArrayList<>();

    //association with an attribute
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    //association - composition
    private List<Document> documents = new ArrayList<>();
    private Set<Document> allDocuments = new HashSet<>();

    public Order(Long id, Project project, Integer price, LocalDate insertionDate, List<Customer> customers) {
        this.id = id;
        this.project = project;
        this.price = price;
        this.insertionDate = insertionDate;
        this.customers = customers;
    }

    //overloaded method
    public Double getPrice(double vatRate) {
        return price + price * vatRate;
    }

    //add association with an attribute
    public void addCustomerAttr(Customer customer, Double price){
        for(CustomerOrder customerOrder : customerOrders){
            if(customerOrder.getCustomer().equals(customer)){
                return;
            }
        }
        CustomerOrder customerOrder = new CustomerOrder(price, customer, this);

        customerOrders.add(customerOrder);
        customer.getCustomerOrders().add(customerOrder);
    }

    //composition adding part
    public void addDocument(Document document) throws AssociationException {
        if(documents.contains(document)){
            throw new AssociationException("Composition - the part is already connected with a whole.");
        }else {
            if(allDocuments.contains(document)){
                throw new AssociationException("Composition - the part is already connected with a whole.");
            }
            document.setOrder(this);
            documents.add(document);

            //adding document to control association rules
            allDocuments.add(document);
        }
    }

    //remove association with an attribute
    public void removeCustomerAttr(Customer customer){
        for (CustomerOrder customerOrder : customerOrders){
            if(customerOrder.getCustomer().equals(customer)){
                customerOrders.remove(customerOrder);
                customer.getCustomerOrders().remove(customerOrder);
                return;
            }
        }
        //customerOrders.removeIf(customerOrder -> customerOrder.getCustomer().equals(customer));
    }

    public String compositionToString(){
        StringBuilder compositionInfo = new StringBuilder("Whole: " + this.getClass().getName() + '\n');
        for (Document document : documents){
            compositionInfo.append(document.getId() + '\n');
        }
        return compositionInfo.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!id.equals(order.id)) return false;
        if (!project.equals(order.project)) return false;
        if (!price.equals(order.price)) return false;
        if (!insertionDate.equals(order.insertionDate)) return false;
        return Objects.equals(allDocuments, order.allDocuments);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + project.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + insertionDate.hashCode();
        return result;
    }

}

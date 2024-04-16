package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.List;

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

}

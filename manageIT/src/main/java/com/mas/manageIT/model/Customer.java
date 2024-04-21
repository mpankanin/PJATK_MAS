package com.mas.manageIT.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Customer extends Person {

    @NonNull
    @Size(max = 50)
    private String company;

    private List<Order> orders;

    private static List<Customer> extent = new ArrayList<>();

    //association with an attribute
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public Customer() {
        addCustomer(this);
    }

    public Customer(Long id, String name, String surname, String email, String phoneNumber, String correspondenceAddress, @NonNull String company) {
        super(id, name, surname, email, phoneNumber, correspondenceAddress);
        this.company = company;
        addCustomer(this);
    }

    public static void addCustomer(Customer customer){
        extent.add(customer);
    }

    public static void removeCustomer(Customer customer){
        extent.remove(customer);
    }

    //class method
    public static void showExtent(){
        System.out.println("Extent of the class: " + Customer.class.getName());
        for (Customer customer : extent){
            System.out.println(customer);
        }
    }

    public static List<Customer> getCustomers() {
        return extent;
    }

    //add association with an attribute
    public void addOrderAttr(Order order, Double price){
        for(CustomerOrder customerOrder : customerOrders){
            if(customerOrder.getOrder().equals(order)){
                return;
            }
        }
        CustomerOrder customerOrder = new CustomerOrder(price, this, order);

        customerOrders.add(customerOrder);
        order.getCustomerOrders().add(customerOrder);
    }

    //remove association with an attribute
    public void removeOrderAttr(Order order){
        for(CustomerOrder customerOrder : customerOrders){
            if(customerOrder.getOrder().equals(order)){
                customerOrders.remove(customerOrder);
                order.getCustomerOrders().remove(customerOrder);
                return;
            }
        }
        //customerOrders.removeIf(customerOrder -> customerOrder.getOrder().equals(order));
    }

    //override method
    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }

}

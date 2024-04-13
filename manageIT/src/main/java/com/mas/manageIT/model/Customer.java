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

    private static List<Customer> extent = new ArrayList<>();

    public Customer() {
        addCustomer(this);
    }

    public Customer(String name, String surname, String email, String phoneNumber, String correspondenceAddress, @NonNull String company) {
        super(name, surname, email, phoneNumber, correspondenceAddress);
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

    //override method
    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }

}

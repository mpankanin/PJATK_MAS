package com.mas.manageIT.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Customer extends Person {

    private String company;

    private String correspondenceAddress;

    private static List<Customer> extent = new ArrayList<>();

    public Customer(String name, String surname, String email, String company, String correspondenceAddress) {
        super(name, surname, email);
        this.company = company;
        this.correspondenceAddress = correspondenceAddress;
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

    //override method
    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }

}

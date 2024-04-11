package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Person {

    private String company;
    private String correspondenceAddress;

    private static List<Customer> extent = new ArrayList<>();


    public void addCustomer(Customer customer){
        extent.add(customer);
    }

    public void removeCustomer(Customer customer){
        extent.remove(customer);
    }

    public void showExtent(){
        System.out.println("Extent of the class: " + this.getClass().getName());
        for (Customer customer : extent){
            System.out.println(customer);
        }
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}

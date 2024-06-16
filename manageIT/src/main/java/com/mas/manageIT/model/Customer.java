package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends Person {

    private String company;

    private List<Order> orders;

    private static List<Customer> extent = new ArrayList<>();


    public static void addCustomer(Customer customer){
        extent.add(customer);
    }

    public static void removeCustomer(Customer customer){
        extent.remove(customer);
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + Customer.class.getName());
        for (Customer customer : extent){
            System.out.println(customer);
        }
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Boolean isMale() {
        return super.getIsArmyMember() != null && super.getIsArmyMember();
    }

}

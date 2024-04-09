package com.mas.manageIT.model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {

    private String company;
    private String correspondenceAddress;

    private static List<Customer> extent = new ArrayList<>();

    public Customer(String firstName, String lastName, String email, String company, String correspondenceAddress) {
        super(firstName, lastName, email);
        this.company = company;
        this.correspondenceAddress = correspondenceAddress;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(String correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

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

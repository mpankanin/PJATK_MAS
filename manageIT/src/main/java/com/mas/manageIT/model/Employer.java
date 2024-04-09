package com.mas.manageIT.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Employer extends Person{

    private String role;

    //composite attribute
    private LocalDate hireDate;

    //optional attribute
    private Optional<Integer> bonus;

    //extension
    private static List<Employer> extent = new ArrayList<>();

    public Employer(String firstName, String lastName, String email, String role) {
        super(firstName, lastName, email);
        this.role = role;
        this.hireDate = LocalDate.now();
        bonus = Optional.empty();
        addEmployer(this);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Optional<Integer> getBonus() {
        return bonus;
    }

    public void setBonus(Optional<Integer> bonus) {
        this.bonus = bonus;
    }

    public void addEmployer(Employer employer){
        extent.add(employer);
    }

    public void removeEmployer(Employer employer){
        extent.remove(employer);
    }

    public void showExtent(){
        System.out.println("Extent of the class: " + this.getClass().getName());
        for (Employer employer : extent){
            System.out.println(employer);
        }
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "{id: " + super.getId() +
                ", name: " + super.getFirstName() +
                ", lastName: " + super.getLastName() +
                ", email: " + super.getEmail() +
                ", role: " + role +
                ", hireDate: " + hireDate +
                ", bonus: " + (bonus.orElse(0)) +
                "}";
    }
}

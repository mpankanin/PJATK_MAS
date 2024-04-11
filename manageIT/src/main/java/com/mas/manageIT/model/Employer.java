package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employer extends Person{

    private String role;

    //composite attribute
    private LocalDate hireDate;

    //optional attribute
    private Optional<Integer> bonus;

    //extension
    private static List<Employer> extent = new ArrayList<>();


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

package com.mas.manageIT.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
public class Employer extends Person{

    @NonNull
    @Size(max = 50)
    private String role;

    //composite attribute
    @NonNull
    private LocalDate hireDate;

    @NonNull
    private Integer salary;

    //optional attribute
    private Optional<Integer> bonus;

    //extension
    private static List<Employer> extent = new ArrayList<>();

    public Employer() {
        this.hireDate = LocalDate.now();
        this.bonus = Optional.empty();
        addEmployer(this);
    }

    public Employer(Long id, String name, String surname, String email, String phoneNumber, String correspondenceAddress, @NonNull String role, Integer bonus) {
        super(id, name, surname, email, phoneNumber, correspondenceAddress);
        this.role = role;
        this.hireDate = LocalDate.now();
        this.bonus = Optional.ofNullable(bonus);
        addEmployer(this);
    }
    public static List<Employer> getEmployers() {
        return extent;
    }

    public Integer getBonus() {
        return bonus.orElse(0);
    }
    public static void addEmployer(Employer employer){
        extent.add(employer);
    }

    public static void removeEmployer(Employer employer){
        extent.remove(employer);
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + Employer.class.getName());
        for (Employer employer : extent){
            System.out.println(employer);
        }
    }

    //derived attribute
    public int yearsOfService(){
        return LocalDate.now().getYear() - hireDate.getYear();
    }

    public int yearsOfService(LocalDate date){
        return date.getYear() - hireDate.getYear();
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

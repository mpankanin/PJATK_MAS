package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private Integer age;

    @Email
    private String email;

    @Size(min = 9, max = 9)
    private String phoneNumber;

    private String correspondenceAddress;

    private Boolean isArmyMember;

    private String maidenName;

    private Boolean isPregnant;

    public abstract String getType();

    public abstract Boolean isMale();

}

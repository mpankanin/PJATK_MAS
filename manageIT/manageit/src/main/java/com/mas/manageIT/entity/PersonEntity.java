package com.mas.manageIT.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@MappedSuperclass
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private Integer phoneNumber;

    @Column(name = "CORRESPONDENCE_ADDRESS")
    private String correspondenceAddress;

    @Column(name = "IS_ARMY_MEMBER")
    private Boolean isArmyMember;

    @Column(name = "MAIDEN_NAME")
    private String maidenName;

    @Column(name = "IS_PREGNANT")
    private Boolean isPregnant;

}

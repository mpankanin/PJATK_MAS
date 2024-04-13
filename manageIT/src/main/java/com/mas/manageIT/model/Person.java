package com.mas.manageIT.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public abstract class Person {

    @NonNull
    private Long id;

    @NonNull
    @Size(max = 50)
    private String firstName;

    @NonNull
    @Size(max = 50)
    private String lastName;

    @NonNull
    @Email
    private String email;

    @NonNull
    @Size(min = 9, max = 9)
    private String phoneNumber;

    @Nullable
    @Size(max = 100)
    private String correspondenceAddress;

    public Person(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String phoneNumber, @Nullable String correspondenceAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.correspondenceAddress = correspondenceAddress;
    }

    public abstract String getType();

}

package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends Person {

    private String company;

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Boolean isMale() {
        return super.getIsArmyMember() != null && super.getIsArmyMember();
    }

}

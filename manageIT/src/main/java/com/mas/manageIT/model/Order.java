package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @NonNull
    private Long id;

    @NonNull
    private Project project;

    @NonNull
    private Integer price;

    @NonNull
    private LocalDate insertionDate;

    //repeatable attribute
    private List<Customer> customers;

    //overloaded method
    public Double getPrice(double vatRate) {
        return price + price * vatRate;
    }

}

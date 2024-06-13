package com.mas.manageIT.model;

import com.mas.manageIT.model.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order {

    private Long id;

    private LocalDate insertionDate;

    private Integer price;

    private PaymentStatus paymentStatus;

    private Customer customer;

    private Project project;

    private List<Document> documents;

}

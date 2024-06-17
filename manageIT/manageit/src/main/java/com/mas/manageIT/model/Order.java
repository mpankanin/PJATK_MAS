package com.mas.manageIT.model;

import com.mas.manageIT.associacion_manager.ObjectPlusPlus;
import com.mas.manageIT.model.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Order extends ObjectPlusPlus {

    private Long id;

    private LocalDate insertionDate;

    private Double price;

    private PaymentStatus paymentStatus;

}

package com.mas.manageIT.service;

import com.mas.manageIT.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    List<Order> getAll(Long customerId);

}

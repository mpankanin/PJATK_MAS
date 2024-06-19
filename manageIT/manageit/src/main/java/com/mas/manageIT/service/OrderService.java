package com.mas.manageIT.service;

import com.mas.manageIT.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    List<Order> getAll(Long customerId);
    Order get(Long orderId);
    void cancel(Long orderId);
    Order pay(Long orderId);

}

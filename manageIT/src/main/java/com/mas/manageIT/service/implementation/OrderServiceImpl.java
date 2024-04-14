package com.mas.manageIT.service.implementation;

import com.mas.manageIT.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

}

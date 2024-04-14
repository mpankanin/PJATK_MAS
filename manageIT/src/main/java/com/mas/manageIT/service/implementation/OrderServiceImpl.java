package com.mas.manageIT.service.implementation;

import com.mas.manageIT.repository.OrderRepository;
import com.mas.manageIT.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

}

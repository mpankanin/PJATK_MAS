package com.mas.manageIT.controller;

import com.mas.manageIT.model.Order;
import com.mas.manageIT.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAll(){
        List<Order> orders = orderService.getAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Order>> getAll(@PathVariable long customerId){
        List<Order> orders = orderService.getAll(customerId);
        return ResponseEntity.ok(orders);
    }

}

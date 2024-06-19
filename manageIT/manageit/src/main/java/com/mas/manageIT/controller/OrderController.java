package com.mas.manageIT.controller;

import com.mas.manageIT.exception.OrderNotFoundException;
import com.mas.manageIT.model.Order;
import com.mas.manageIT.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("customer/{customerId}")
    public ResponseEntity<List<Order>> getAll(@PathVariable long customerId){
        List<Order> orders = orderService.getAll(customerId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> get(@PathVariable long orderId){
        Order order = orderService.get(orderId);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Void> delete(@PathVariable long orderId){
        try {
            orderService.cancel(orderId);
            return ResponseEntity.noContent().build();
        } catch (OrderNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/pay/{orderId}")
    public ResponseEntity<Order> pay(@PathVariable long orderId){
        try {
            Order order = orderService.pay(orderId);
            return ResponseEntity.ok(order);
        } catch (OrderNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

}

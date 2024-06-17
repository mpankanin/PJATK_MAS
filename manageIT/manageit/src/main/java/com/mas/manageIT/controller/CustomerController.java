package com.mas.manageIT.controller;

import com.mas.manageIT.model.Customer;
import com.mas.manageIT.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> customers = customerService.getAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> get(@PathVariable long customerId){
        Customer customer = customerService.get(customerId);
        return ResponseEntity.ok(customer);
    }

}

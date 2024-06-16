package com.mas.manageIT.controller;

import com.mas.manageIT.model.Customer;
import com.mas.manageIT.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> customers = (List<Customer>) customerService.getAll();
        return ResponseEntity.ok(customers);
    }


}

package com.mas.manageIT.service;

import com.mas.manageIT.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    Customer get(Long customerId);

}

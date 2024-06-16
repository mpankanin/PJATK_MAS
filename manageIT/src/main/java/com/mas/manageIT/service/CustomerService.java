package com.mas.manageIT.service;

import com.mas.manageIT.entity.CustomerEntity;
import com.mas.manageIT.model.Customer;

public interface CustomerService {

    void save(CustomerEntity customer);
    void delete(CustomerEntity customer);
    CustomerEntity getById(Long id);
    Iterable<Customer> getAll();

}

package com.mas.manageIT.service;

import com.mas.manageIT.entity.CustomerEntity;
import com.mas.manageIT.model.Customer;
import com.mas.manageIT.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(CustomerEntity customer) {
        customerRepository.save(customer);
    }

    public void delete(CustomerEntity customer) {
        customerRepository.delete(customer);
    }

    public CustomerEntity getById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Iterable<CustomerEntity> getAll() {
        return customerRepository.findAll();
    }

}

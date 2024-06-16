package com.mas.manageIT.service.implementation;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.entity.CustomerEntity;
import com.mas.manageIT.model.Customer;
import com.mas.manageIT.repository.CustomerRepository;
import com.mas.manageIT.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
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

    public Iterable<Customer> getAll() {
        try {
            return ObjectPlus.getExtent(Customer.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

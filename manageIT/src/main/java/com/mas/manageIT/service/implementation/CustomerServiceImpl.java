package com.mas.manageIT.service.implementation;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.entity.CustomerEntity;
import com.mas.manageIT.model.Customer;
import com.mas.manageIT.repository.CustomerRepository;
import com.mas.manageIT.service.CustomerService;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        try {
            return (List<Customer>) ObjectPlus.getExtent(Customer.class);
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Couldn't get a customer's extent.");
        }
        return new ArrayList<>();
    }

    @Override
    public Customer get(Long customerId) {
        return null;
    }

}

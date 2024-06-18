package com.mas.manageIT.service.implementation;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.exception.CustomerNotFoundException;
import com.mas.manageIT.exception.OrderNotFoundException;
import com.mas.manageIT.model.Customer;
import com.mas.manageIT.model.Order;
import com.mas.manageIT.repository.CustomerRepository;
import com.mas.manageIT.service.CustomerService;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
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
        try {
            List<Customer> extent = (List<Customer>) Customer.getExtent(Customer.class);
            Optional<Customer> optional = extent.stream().filter(c -> c.getId().equals(customerId)).findFirst();
            if (optional.isPresent()){
                return optional.get();
            }else {
                throw new CustomerNotFoundException("Customer: " + customerId + " doesn't exist.");
            }
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Couldn't get a customer's extent.");
        }
        return null;
    }

}

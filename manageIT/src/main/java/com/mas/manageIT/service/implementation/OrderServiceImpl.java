package com.mas.manageIT.service.implementation;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.associacion_manager.ObjectPlusPlus;
import com.mas.manageIT.exception.CustomerNotFoundException;
import com.mas.manageIT.model.Customer;
import com.mas.manageIT.model.Order;
import com.mas.manageIT.repository.OrderRepository;
import com.mas.manageIT.service.OrderService;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        try {
            return (List<Order>) ObjectPlus.getExtent(Order.class);
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Couldn't get a order's extent.");
        }
        return new ArrayList<>();
    }

    @Override
    public List<Order> getAll(Long customerId) {
        try {
            List<Customer> customerExtent = (List<Customer>) Customer.getExtent(Customer.class);
            Optional<Customer> optional = customerExtent.stream().filter(c -> c.getId().equals(customerId)).findFirst();
            if (optional.isPresent()){
                Customer customer = optional.get();
                ObjectPlusPlus[] links = customer.getLinks("CustomerOrder");
                return Arrays.stream(links)
                        .map(link -> (Order) link)
                        .toList();
            } else
                throw new CustomerNotFoundException("Customer: " + customerId + " doesn't exist.");
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Couldn't get a customer's extent.");
        } catch (Exception e) {
            logger.error(() -> "Couldn't get links for: " + customerId);
        }
        return new ArrayList<>();
    }

    @Override
    public Order get(Long orderId) {
        return null;
    }

}

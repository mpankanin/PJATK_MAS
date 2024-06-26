package com.mas.manageIT.mapper;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.associacion_manager.ObjectPlusPlus;
import com.mas.manageIT.entity.CustomerEntity;
import com.mas.manageIT.entity.OrderEntity;
import com.mas.manageIT.model.Customer;
import com.mas.manageIT.model.Order;
import com.mas.manageIT.service.CustomerService;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OrderMapper {

    private static final Logger logger = LoggerFactory.getLogger(OrderMapper.class);


    public static Order toModel(OrderEntity orderEntity) {
        Order order = new Order();

        order.setId(orderEntity.getId());
        order.setInsertionDate(orderEntity.getInsertionDate());
        order.setPrice(orderEntity.getPrice());
        order.setPaymentStatus(orderEntity.getPaymentStatus());
        addOrderCustomerLink(order, orderEntity.getCustomer().getId()); //link
        return order;
    }

    public static OrderEntity toEntity(Order order){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setInsertionDate(order.getInsertionDate());
        orderEntity.setPrice(order.getPrice());
        orderEntity.setPaymentStatus(order.getPaymentStatus());
        orderEntity.setCustomer(getCustomerLink(order)); //foreign key
        return orderEntity;
    }

    private static void addOrderCustomerLink(Order order, Long customerId){
        try {
            List<Customer> customerExtent = (List<Customer>) ObjectPlus.getExtent(Customer.class);
            Optional<Customer> theCustomer = customerExtent.stream()
                    .filter(customer -> customer.getId().equals(customerId))
                    .findFirst();
            if (theCustomer.isPresent()){
                order.addLink("OrderCustomer", "CustomerOrder", theCustomer.get());
            } else {
                logger.error(() -> "Getting customer: " + customerId + " from extent failed.");
            }
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Getting customer's extent failed.");
        }
    }

    private static CustomerEntity getCustomerLink(Order order) {
        try {
            ObjectPlusPlus[] links = order.getLinks("OrderCustomer");
            Customer customer = (Customer) links[0];
            return CustomerMapper.toEntity(customer);
        } catch (Exception e) {
            logger.error(() -> "Getting customer from a link failed.");
        }
        return null;
    }

}

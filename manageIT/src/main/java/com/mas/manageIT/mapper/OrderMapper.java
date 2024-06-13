package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.OrderEntity;
import com.mas.manageIT.model.Order;

public class OrderMapper {

    public static Order toModel(OrderEntity orderEntity) {
        Order order = new Order();

        order.setId(orderEntity.getId());
        order.setInsertionDate(orderEntity.getInsertionDate());
        order.setPrice(orderEntity.getPrice());
        order.setPaymentStatus(orderEntity.getPaymentStatus());
        return order;
    }

    public static OrderEntity toEntity(Order order){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setInsertionDate(order.getInsertionDate());
        orderEntity.setPrice(order.getPrice());
        orderEntity.setPaymentStatus(order.getPaymentStatus());
        return orderEntity;
    }

}

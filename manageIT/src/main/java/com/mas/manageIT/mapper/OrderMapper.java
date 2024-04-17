package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.OrderEntity;
import com.mas.manageIT.model.Order;

import java.util.HashSet;
import java.util.stream.Collectors;

public class OrderMapper {

    public static Order toModel(OrderEntity orderEntity) {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setProject(ProjectMapper.toModel(orderEntity.getProject()));
        order.setPrice(orderEntity.getPrice());
        order.setInsertionDate(orderEntity.getInsertionDate());
        order.setCustomers(orderEntity.getCustomers().stream().map(CustomerMapper::toModel).collect(Collectors.toList()));
        order.setDocuments(orderEntity.getDocuments().stream().map(DocumentMapper::toModel).collect(Collectors.toList()));
        order.setAllDocuments(new HashSet<>(order.getDocuments()));
        return order;
    }

    public static OrderEntity toEntity(Order order){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setProject(ProjectMapper.toEntity(order.getProject()));
        orderEntity.setPrice(order.getPrice());
        orderEntity.setInsertionDate(order.getInsertionDate());
        orderEntity.setCustomers(order.getCustomers().stream().map(CustomerMapper::toEntity).collect(Collectors.toList()));
        orderEntity.setDocuments(order.getDocuments().stream().map(DocumentMapper::toEntity).collect(Collectors.toList()));
        return orderEntity;
    }

}

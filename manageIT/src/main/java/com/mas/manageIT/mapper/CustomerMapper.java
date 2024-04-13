package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.CustomerEntity;
import com.mas.manageIT.model.Customer;

public class CustomerMapper {

    public static Customer toModel(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setId(customerEntity.getId());
        customer.setFirstName(customerEntity.getFirstName());
        customer.setLastName(customerEntity.getLastName());
        customer.setEmail(customerEntity.getEmail());
        customer.setPhoneNumber(customerEntity.getPhoneNumber());
        customer.setCorrespondenceAddress(customerEntity.getCorrespondenceAddress());
        customer.setCompany(customerEntity.getCompany());
        return customer;
    }

    public static CustomerEntity toEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId());
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerEntity.setCorrespondenceAddress(customer.getCorrespondenceAddress());
        customerEntity.setCompany(customer.getCompany());
        return customerEntity;
    }
}

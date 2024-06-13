package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.CustomerEntity;
import com.mas.manageIT.model.Customer;

public class CustomerMapper {

    public static Customer toModel(CustomerEntity customerEntity) {
        Customer customer = new Customer();

        customer.setId(customerEntity.getId());
        customer.setFirstName(customerEntity.getFirstName());
        customer.setLastName(customerEntity.getLastName());
        customer.setBirthDate(customerEntity.getBirthDate());
        customer.setEmail(customerEntity.getEmail());
        customer.setPhoneNumber(customerEntity.getPhoneNumber());
        customer.setCorrespondenceAddress(customerEntity.getCorrespondenceAddress());
        customer.setIsArmyMember(customerEntity.getIsArmyMember());
        customer.setMaidenName(customerEntity.getMaidenName());
        customer.setIsPregnant(customerEntity.getIsPregnant());
        customer.setCompany(customerEntity.getCompany());
        return customer;
    }

    public static CustomerEntity toEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId(customer.getId());
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setBirthDate(customer.getBirthDate());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerEntity.setCorrespondenceAddress(customer.getCorrespondenceAddress());
        customerEntity.setIsArmyMember(customer.getIsArmyMember());
        customerEntity.setMaidenName(customer.getMaidenName());
        customerEntity.setIsPregnant(customer.getIsPregnant());
        customerEntity.setCompany(customer.getCompany());
        return customerEntity;
    }

}

package com.mas.manageIT.service;

import com.mas.manageIT.entity.CustomerEntity;

public interface CustomerService {

    void save(CustomerEntity customer);
    void delete(CustomerEntity customer);
    CustomerEntity getById(Long id);
    Iterable<CustomerEntity> getAll();

}

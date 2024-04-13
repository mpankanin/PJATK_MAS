package com.mas.manageIT.repository;

import com.mas.manageIT.entity.CustomerEntity;
import com.mas.manageIT.mapper.CustomerMapper;
import com.mas.manageIT.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void whenFindById_thenReturnCustomer() {
        // given
        Customer customer = new Customer(1L, "John", "Doe", "john.doe@example.com", "1234567890", "123 Street", "Company");

        customerRepository.save(CustomerMapper.toEntity(customer));

        // when
        Optional<CustomerEntity> found = customerRepository.findById(customer.getId());

        // then
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getEmail()).isEqualTo(customer.getEmail());
    }

    @Test
    public void whenDelete_thenDoesNotExist() {
        // given
        Customer customer = new Customer(1L, "John", "Doe", "john.doe@example.com", "1234567890", "123 Street", "Company");

        Optional<CustomerEntity> found = customerRepository.findById(customer.getId());
        if(found.isEmpty()){
            customerRepository.save(CustomerMapper.toEntity(customer));
        }

        // when
        customerRepository.delete(CustomerMapper.toEntity(customer));
        Optional<CustomerEntity> dbOutput = customerRepository.findById(customer.getId());

        // then
        assertTrue(dbOutput.isEmpty());
    }

}
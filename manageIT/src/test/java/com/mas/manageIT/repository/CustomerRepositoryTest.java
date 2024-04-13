package com.mas.manageIT.repository;

import com.mas.manageIT.entity.CustomerEntity;
import com.mas.manageIT.mapper.CustomerMapper;
import com.mas.manageIT.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void whenFindById_thenReturnCustomer() {
        // given
        Customer customer = new Customer("John", "Doe", "john.doe@example.com", "1234567890", "123 Street", "Company");
        entityManager.persistAndFlush(CustomerMapper.toEntity(customer));

        // when
        Optional<Customer> found = customerRepository.findById(customer.getId());

        // then
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getEmail()).isEqualTo(customer.getEmail());
    }

}
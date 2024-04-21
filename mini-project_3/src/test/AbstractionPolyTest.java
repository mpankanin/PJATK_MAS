package test;

import abstraction_poly.Customer;
import abstraction_poly.Employer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AbstractionPolyTest {

    @Test
    void should_create_Customer() {
        //given
        Customer customer = new Customer("John", "Doe", "johndoe@company.com", "123456789", "Correspondence Address", "Company");

        //when
        //then
        assertEquals("Company", customer.getCompany());
    }

    @Test
    void should_create_Employer() {
        //given
        Employer employer = new Employer("John", "Doe", "johndoe@company.com", "123456789", "Correspondence Address", "Role", LocalDate.now(), 1000);

        //when
        //then
        assertEquals("Role", employer.getRole());
    }

    @Test
    void should_getType_return_different_values() {
        //given
        Customer customer = new Customer("John", "Doe", "johndoe@company.com", "123456789", "Correspondence Address", "Company");
        Employer employer = new Employer("John", "Doe", "johndoe@company.com", "123456789", "Correspondence Address", "Role", LocalDate.now(), 1000);

        //when
        //then
        assertEquals("Customer", customer.getType());
        assertEquals("Employer", employer.getType());
        assertNotEquals(customer.getType(), employer.getType());
    }

}

package test;

import multi_aspect.Customer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MultiAspectTest {

    @Test
    void should_create_Male_Customer() {
        //given
        Customer customer = new Customer("John", "Doe", LocalDate.of(1990, 1, 1), null, null, true, 0.1);

        //when
        //then
        assertNull(customer.getMaidenName());
        assertNull(customer.getIsPregnant());
        assertEquals(Boolean.TRUE, customer.getIsArmyMember());
    }

    @Test
    void should_create_Female_Customer() {
        //given
        Customer customer = new Customer("Jane", "Doe", LocalDate.of(1990, 1, 1), "Maiden", true, null, 0.1);

        //when
        //then
        assertEquals("Maiden", customer.getMaidenName());
        assertEquals(Boolean.TRUE, customer.getIsPregnant());
        assertNull(customer.getIsArmyMember());
    }

}

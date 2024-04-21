package test;

import exceptions.DeveloperNotFoundException;
import exceptions.ProductOwnerNotFoundException;
import org.junit.jupiter.api.Test;
import overlapping.PersonOverlapping;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OverlappingTest {

    @Test
    void should_create_Developer() {
        //given
        List<String> knownProgrammingLanguages = List.of("Java", "Python");
        PersonOverlapping person = new PersonOverlapping("John", "Doe", LocalDate.of(1990, 1, 1));
        PersonOverlapping person2 = new PersonOverlapping("John", "Doe", LocalDate.of(1990, 1, 1), knownProgrammingLanguages);

        //when
        person.addDeveloper(knownProgrammingLanguages);

        //then
        try {
            assertEquals(knownProgrammingLanguages, person.getKnownProgrammingLanguages());
            assertEquals(knownProgrammingLanguages, person2.getKnownProgrammingLanguages());
        } catch (DeveloperNotFoundException e) {
            throw new RuntimeException(e);
        }
        assertThrows(ProductOwnerNotFoundException.class, person::getProductName);
        assertThrows(ProductOwnerNotFoundException.class, person2::getProductName);
    }

    @Test
    void should_create_ProductOwner() {
        //given
        String productName = "Product1";
        PersonOverlapping person = new PersonOverlapping("John", "Doe", LocalDate.of(1990, 1, 1));
        PersonOverlapping person2 = new PersonOverlapping("John", "Doe", LocalDate.of(1990, 1, 1), productName);

        //when
        person.addProductOwner(productName);

        //then
        try {
            assertEquals(productName, person.getProductName());
            assertEquals(productName, person2.getProductName());
        } catch (ProductOwnerNotFoundException e) {
            throw new RuntimeException(e);
        }
        assertThrows(DeveloperNotFoundException.class, person::getKnownProgrammingLanguages);
        assertThrows(DeveloperNotFoundException.class, person2::getKnownProgrammingLanguages);
    }

    @Test
    void should_create_Developer_ProductOwner() {
        //given
        List<String> knownProgrammingLanguages = List.of("Java", "Python");
        String productName = "Product1";
        PersonOverlapping person = new PersonOverlapping("John", "Doe", LocalDate.of(1990, 1, 1));

        //when
        person.addDeveloper(knownProgrammingLanguages);
        person.addProductOwner(productName);

        //then
        try {
            assertEquals(knownProgrammingLanguages, person.getKnownProgrammingLanguages());
            assertEquals(productName, person.getProductName());
        } catch (DeveloperNotFoundException | ProductOwnerNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

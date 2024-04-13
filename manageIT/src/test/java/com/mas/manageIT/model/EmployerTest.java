package com.mas.manageIT.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployerTest {

    @Test
    void getBonus() {
        // given
        Employer employerWithBonus = new Employer();
        employerWithBonus.setSalary(1000);
        employerWithBonus.setBonus(Optional.of(100));

        Employer employerWithoutBonus = new Employer();
        employerWithoutBonus.setSalary(1000);

        // when
        int bonus = employerWithBonus.getBonus();
        int noBonus = employerWithoutBonus.getBonus();

        // then
        assertEquals(100, bonus);
        assertEquals(0, noBonus);
    }

    @Test
    void addEmployer() {
        // given
        Employer employer1 = new Employer();
        Employer employer2 = new Employer();

        // when
        // then
        assertEquals(2, Employer.getEmployers().size());
    }

    @Test
    void removeEmployer() {
        // given
        Employer employer1 = new Employer();
        Employer employer2 = new Employer();

        // when
        Employer.removeEmployer(employer1);

        // then
        assertEquals(1, Employer.getEmployers().size());
    }

    @Test
    void yearsOfService() {
        // given
        Employer employer = new Employer();
        Employer employer2020 = new Employer();
        employer2020.setHireDate(java.time.LocalDate.of(2020, 1, 1));

        LocalDate date2023 = LocalDate.of(2023, 1, 1);

        // when
        int zeroYearsOfService = employer.yearsOfService();
        int threeYearsOfService = employer2020.yearsOfService(date2023);

        // then
        assertEquals(0, zeroYearsOfService);
        assertEquals(3, threeYearsOfService);
    }

    @Test
    void getType() {
        // given
        Employer employer = new Employer();

        // when
        String type = employer.getType();

        // then
        assertEquals("Employer", type);
    }

}
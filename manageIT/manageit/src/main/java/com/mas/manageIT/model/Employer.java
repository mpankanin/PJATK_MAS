package com.mas.manageIT.model;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class Employer extends Person{

    private LocalDate hireDate;

    private LocalDate releaseDate;

    private Double salary;

    private Double bonus;


    public static void releaseEmployer(Long employerId){
        Logger logger = LoggerFactory.getLogger(Employer.class);
        try {
            List<Employer> employers = (List<Employer>) ObjectPlus.getExtent(Employer.class);
            Optional<Employer> optional = employers.stream().filter(emp -> emp.getId().equals(employerId)).findFirst();
            if (optional.isPresent()){
                optional.get().setReleaseDate(LocalDate.now());
            } else {
                logger.error(() -> "Employer: " + employerId + " doesn't exist.");
            }
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Couldn't get a customer's extent.");
        }
    }

}

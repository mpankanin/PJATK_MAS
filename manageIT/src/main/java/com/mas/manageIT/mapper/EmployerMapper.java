package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.EmployerEntity;
import com.mas.manageIT.model.Employer;

import java.util.Optional;

public class EmployerMapper {

    public static Employer toModel(EmployerEntity employerEntity) {
        Employer employer = new Employer();
        employer.setId(employerEntity.getId());
        employer.setFirstName(employerEntity.getFirstName());
        employer.setLastName(employerEntity.getLastName());
        employer.setEmail(employerEntity.getEmail());
        employer.setPhoneNumber(employerEntity.getPhoneNumber());
        employer.setCorrespondenceAddress(employerEntity.getCorrespondenceAddress());
        employer.setRole(employerEntity.getRole());
        employer.setSalary(employerEntity.getSalary());
        employer.setBonus(Optional.ofNullable(employerEntity.getBonus()));
        return employer;
    }

    public static EmployerEntity toEntity(Employer employer){
        EmployerEntity employerEntity = new EmployerEntity();
        employerEntity.setId(employer.getId());
        employerEntity.setFirstName(employer.getFirstName());
        employerEntity.setLastName(employer.getLastName());
        employerEntity.setEmail(employer.getEmail());
        employerEntity.setPhoneNumber(employer.getPhoneNumber());
        employerEntity.setCorrespondenceAddress(employer.getCorrespondenceAddress());
        employerEntity.setRole(employer.getRole());
        employerEntity.setSalary(employer.getSalary());
        employerEntity.setBonus(employer.getBonus());
        return employerEntity;
    }

}

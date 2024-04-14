package com.mas.manageIT.service.implementation;

import com.mas.manageIT.repository.EmployerRepository;
import com.mas.manageIT.service.EmployerService;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

}

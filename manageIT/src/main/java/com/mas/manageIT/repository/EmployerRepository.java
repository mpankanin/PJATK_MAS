package com.mas.manageIT.repository;

import com.mas.manageIT.entity.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<EmployerEntity, Long> {
}

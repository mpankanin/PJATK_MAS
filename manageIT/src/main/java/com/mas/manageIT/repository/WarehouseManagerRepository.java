package com.mas.manageIT.repository;

import com.mas.manageIT.entity.WarehouseManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseManagerRepository extends JpaRepository<WarehouseManagerEntity, Long>{
}

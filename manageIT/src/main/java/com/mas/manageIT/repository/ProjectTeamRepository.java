package com.mas.manageIT.repository;

import com.mas.manageIT.entity.ProjectTeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTeamRepository extends JpaRepository<ProjectTeamEntity, Long> {
}

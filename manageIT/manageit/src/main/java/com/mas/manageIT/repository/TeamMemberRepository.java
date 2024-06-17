package com.mas.manageIT.repository;

import com.mas.manageIT.entity.TeamMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMemberEntity, Long> {
}

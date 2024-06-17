package com.mas.manageIT.service.implementation;

import com.mas.manageIT.repository.TeamMemberRepository;
import com.mas.manageIT.service.TeamMemberService;
import org.springframework.stereotype.Service;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;


    public TeamMemberServiceImpl(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

}

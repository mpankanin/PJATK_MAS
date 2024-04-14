package com.mas.manageIT.service.implementation;

import com.mas.manageIT.repository.ResourceRepository;
import com.mas.manageIT.service.ResourceService;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

}

package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.ResourceEntity;
import com.mas.manageIT.model.Resource;

public class ResourceMapper {

    public static Resource toModel(ResourceEntity resourceEntity) {
        Resource resource = new Resource();
        resource.setId(resourceEntity.getId());
        resource.setName(resourceEntity.getName());
        resource.setResourceType(resourceEntity.getResourceType());
        resource.setResourceState(resourceEntity.getResourceState());
        resource.setPurchaseDate(resourceEntity.getPurchaseDate());
        resource.setCareTaker(EmployerMapper.toModel(resourceEntity.getCareTaker()));
        resource.setAssignee(EmployerMapper.toModel(resourceEntity.getAssignee()));
        return resource;
    }

    public static ResourceEntity toEntity(Resource resource){
        ResourceEntity resourceEntity = new ResourceEntity();
        resourceEntity.setId(resource.getId());
        resourceEntity.setName(resource.getName());
        resourceEntity.setResourceType(resource.getResourceType());
        resourceEntity.setResourceState(resource.getResourceState());
        resourceEntity.setPurchaseDate(resource.getPurchaseDate());
        resourceEntity.setCareTaker(EmployerMapper.toEntity(resource.getCareTaker()));
        resourceEntity.setAssignee(EmployerMapper.toEntity(resource.getAssignee()));
        return resourceEntity;
    }

}

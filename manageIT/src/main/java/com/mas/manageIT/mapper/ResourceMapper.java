package com.mas.manageIT.mapper;

import com.mas.manageIT.entity.ResourceEntity;
import com.mas.manageIT.model.Resource;

public class ResourceMapper {

    public static Resource toModel(ResourceEntity resourceEntity) {
        Resource resource = new Resource();

        resource.setId(resourceEntity.getId());
        resource.setName(resourceEntity.getName());
        resource.setResourceType(resourceEntity.getResourceType());
        resource.setPurchaseDate(resourceEntity.getPurchaseDate());
        return resource;
    }

    public static ResourceEntity toEntity(Resource resource){
        ResourceEntity resourceEntity = new ResourceEntity();

        resourceEntity.setId(resource.getId());
        resourceEntity.setName(resource.getName());
        resourceEntity.setResourceType(resource.getResourceType());
        resourceEntity.setPurchaseDate(resource.getPurchaseDate());
        return resourceEntity;
    }

}

package com.mas.manageIT.mapper;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.associacion_manager.ObjectPlusPlus;
import com.mas.manageIT.entity.ResourceEntity;
import com.mas.manageIT.entity.TeamMemberEntity;
import com.mas.manageIT.entity.WarehouseEntity;
import com.mas.manageIT.model.Customer;
import com.mas.manageIT.model.Resource;
import com.mas.manageIT.model.TeamMember;
import com.mas.manageIT.model.Warehouse;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class ResourceMapper {

    private static final Logger logger = LoggerFactory.getLogger(ResourceMapper.class);


    public static Resource toModel(ResourceEntity resourceEntity) {
        Resource resource = new Resource();

        resource.setId(resourceEntity.getId());
        resource.setName(resourceEntity.getName());
        resource.setResourceType(resourceEntity.getResourceType());
        resource.setPurchaseDate(resourceEntity.getPurchaseDate());
        addResourceTeamMemberLink(resource, resourceEntity.getAssignee().getId()); //link
        addResourceWarehouseLink(resource, resourceEntity.getWarehouse().getId()); //link
        return resource;
    }

    public static ResourceEntity toEntity(Resource resource){
        ResourceEntity resourceEntity = new ResourceEntity();

        resourceEntity.setId(resource.getId());
        resourceEntity.setName(resource.getName());
        resourceEntity.setResourceType(resource.getResourceType());
        resourceEntity.setPurchaseDate(resource.getPurchaseDate());
        resourceEntity.setAssignee(getTeamMemberLink(resource)); //foreign key
        resourceEntity.setWarehouse(getWarehouseLink(resource)); //foreign key
        return resourceEntity;
    }

    private static void addResourceWarehouseLink(Resource resource, Long warehouseId) {
        try {
            List<Warehouse> warehouseExtent = (List<Warehouse>) ObjectPlus.getExtent(Warehouse.class);
            Optional<Warehouse> theWarehouse = warehouseExtent.stream()
                    .filter(w -> w.getId().equals(warehouseId))
                    .findFirst();
            if (theWarehouse.isPresent()){
                resource.addLink("ResourceWarehouse", "WarehouseResource", theWarehouse.get());
            } else {
                logger.error(() -> "Getting warehouse: " + warehouseId + " from extent failed.");
            }
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Getting warehouse's extent failed.");
        }
    }

    private static void addResourceTeamMemberLink(Resource resource, Long teamMemberId) {
        try {
            List<TeamMember> teamMemberExtent = (List<TeamMember>) ObjectPlus.getExtent(TeamMember.class);
            Optional<TeamMember> theTeamMember = teamMemberExtent.stream()
                    .filter(tm -> tm.getId().equals(teamMemberId))
                    .findFirst();
            if (theTeamMember.isPresent()){
                resource.addLink("ResourceTeamMember", "TeamMemberResource", theTeamMember.get());
            } else {
                logger.error(() -> "Getting team member: " + teamMemberExtent + " from extent failed.");
            }
        } catch (ClassNotFoundException e) {
            logger.error(() -> "Getting team member's extent failed.");
        }
    }

    private static WarehouseEntity getWarehouseLink(Resource resource) {
        try {
            ObjectPlusPlus[] links = resource.getLinks("ResourceWarehouse");
            Warehouse warehouse = (Warehouse) links[0];
            return WarehouseMapper.toEntity(warehouse);
        } catch (Exception e) {
            logger.error(() -> "Getting warehouse from a link failed.");
        }
        return null;
    }

    private static TeamMemberEntity getTeamMemberLink(Resource resource) {
        try {
            ObjectPlusPlus[] links = resource.getLinks("ResourceTeamMember");
            TeamMember teamMember = (TeamMember) links[0];
            return TeamMemberMapper.toEntity(teamMember);
        } catch (Exception e) {
            logger.error(() -> "Getting team member from a link failed.");
        }
        return null;
    }

}

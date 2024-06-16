package com.mas.manageIT.data_loader;

import com.mas.manageIT.associacion_manager.ObjectPlus;
import com.mas.manageIT.mapper.CustomerMapper;
import com.mas.manageIT.mapper.DocumentMapper;
import com.mas.manageIT.mapper.OrderMapper;
import com.mas.manageIT.mapper.ProjectMapper;
import com.mas.manageIT.mapper.ProjectTeamMapper;
import com.mas.manageIT.mapper.ResourceMapper;
import com.mas.manageIT.mapper.TaskMapper;
import com.mas.manageIT.mapper.TeamMemberMapper;
import com.mas.manageIT.mapper.WarehouseManagerMapper;
import com.mas.manageIT.mapper.WarehouseMapper;
import com.mas.manageIT.model.Customer;
import com.mas.manageIT.repository.CustomerRepository;
import com.mas.manageIT.repository.DocumentRepository;
import com.mas.manageIT.repository.OrderRepository;
import com.mas.manageIT.repository.ProjectRepository;
import com.mas.manageIT.repository.ProjectTeamRepository;
import com.mas.manageIT.repository.ResourceRepository;
import com.mas.manageIT.repository.TaskRepository;
import com.mas.manageIT.repository.TeamMemberRepository;
import com.mas.manageIT.repository.WarehouseManagerRepository;
import com.mas.manageIT.repository.WarehouseRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class DataLoadSaveService {

    private final CustomerRepository customerRepository;
    private final DocumentRepository documentRepository;
    private final OrderRepository orderRepository;
    private final ProjectRepository projectRepository;
    private final ProjectTeamRepository projectTeamRepository;
    private final ResourceRepository resourceRepository;
    private final TaskRepository taskRepository;
    private final TeamMemberRepository teamMemberRepository;
    private final WarehouseRepository warehouseRepository;
    private final WarehouseManagerRepository warehouseManagerRepository;


    public DataLoadSaveService(CustomerRepository customerRepository, DocumentRepository documentRepository, OrderRepository orderRepository, ProjectRepository projectRepository, ProjectTeamRepository projectTeamRepository, ResourceRepository resourceRepository, TaskRepository taskRepository, TeamMemberRepository teamMemberRepository, WarehouseRepository warehouseRepository, WarehouseManagerRepository warehouseManagerRepository) {
        this.customerRepository = customerRepository;
        this.documentRepository = documentRepository;
        this.orderRepository = orderRepository;
        this.projectRepository = projectRepository;
        this.projectTeamRepository = projectTeamRepository;
        this.resourceRepository = resourceRepository;
        this.taskRepository = taskRepository;
        this.teamMemberRepository = teamMemberRepository;
        this.warehouseRepository = warehouseRepository;
        this.warehouseManagerRepository = warehouseManagerRepository;
    }

    @PostConstruct
    public void loadData() {
        customerRepository.findAll().forEach(CustomerMapper::toModel);
        orderRepository.findAll().forEach(OrderMapper::toModel);
        documentRepository.findAll().forEach(DocumentMapper::toModel);
        projectTeamRepository.findAll().forEach(ProjectTeamMapper::toModel);
        projectRepository.findAll().forEach(ProjectMapper::toModel);
        warehouseRepository.findAll().forEach(WarehouseMapper::toModel);
        warehouseManagerRepository.findAll().forEach(WarehouseManagerMapper::toModel);
        teamMemberRepository.findAll().forEach(TeamMemberMapper::toModel);
        taskRepository.findAll().forEach(TaskMapper::toModel);
        resourceRepository.findAll().forEach(ResourceMapper::toModel);
    }

    @PreDestroy
    public void saveData() {

    }

}

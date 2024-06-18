package com.mas.manageIT.data_loader;

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
import com.mas.manageIT.model.Document;
import com.mas.manageIT.model.Order;
import com.mas.manageIT.model.ProjectTeam;
import com.mas.manageIT.model.Resource;
import com.mas.manageIT.model.Task;
import com.mas.manageIT.model.TeamMember;
import com.mas.manageIT.model.Warehouse;
import com.mas.manageIT.model.WarehouseManager;
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

import java.util.List;
import java.util.stream.Collectors;

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
        try {
            List<Customer> customerExtent = (List<Customer>) Customer.getExtent(Customer.class);
            List<Order> orderExtent = (List<Order>) Order.getExtent(Order.class);
            List<Document> documentExtent = (List<Document>) Document.getExtent(Document.class);
            List<ProjectTeam> projectTeamExtent = (List<ProjectTeam>) ProjectTeam.getExtent(ProjectTeam.class);
            List<Warehouse> warehouseExtent = (List<Warehouse>) Warehouse.getExtent(Warehouse.class);
            List<WarehouseManager> warehouseManagerExtent = (List<WarehouseManager>) WarehouseManager.getExtent(WarehouseManager.class);
            List<TeamMember> teamMemberExtent = (List<TeamMember>) TeamMember.getExtent(TeamMember.class);
            List<Task> taskExtent = (List<Task>) Task.getExtent(Task.class);
            List<Resource> resourceExtent = (List<Resource>) Resource.getExtent(Resource.class);

            customerRepository.saveAll(customerExtent.stream().map(CustomerMapper::toEntity).collect(Collectors.toList()));
            orderRepository.saveAll(orderExtent.stream().map(OrderMapper::toEntity).collect(Collectors.toList()));
            documentRepository.saveAll(documentExtent.stream().map(DocumentMapper::toEntity).collect(Collectors.toList()));
            projectTeamRepository.saveAll(projectTeamExtent.stream().map(ProjectTeamMapper::toEntity).collect(Collectors.toList()));
            warehouseRepository.saveAll(warehouseExtent.stream().map(WarehouseMapper::toEntity).collect(Collectors.toList()));
            warehouseManagerRepository.saveAll(warehouseManagerExtent.stream().map(WarehouseManagerMapper::toEntity).collect(Collectors.toList()));
            teamMemberRepository.saveAll(teamMemberExtent.stream().map(TeamMemberMapper::toEntity).collect(Collectors.toList()));
            taskRepository.saveAll(taskExtent.stream().map(TaskMapper::toEntity).collect(Collectors.toList()));
            resourceRepository.saveAll(resourceExtent.stream().map(ResourceMapper::toEntity).collect(Collectors.toList()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

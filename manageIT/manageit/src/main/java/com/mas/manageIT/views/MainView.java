package com.mas.manageIT.views;

import com.mas.manageIT.model.Customer;
import com.mas.manageIT.service.CustomerService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import java.util.List;

@Route
public class MainView extends VerticalLayout{

    private CustomerService customerService;
    private Grid<Customer> grid;


    public MainView(CustomerService customerService) {
        this.customerService = customerService;
        this.grid = new Grid<>(Customer.class);
        add(grid);
        listCustomers();
    }

    private void listCustomers() {
        List<Customer> customers = customerService.getAll();
        grid.setItems(customers);
        grid.addItemClickListener(event -> {
            Customer customer = event.getItem();
            if (customer != null) {
                getUI().ifPresent(ui -> ui.navigate("orders/customer/" + customer.getId()));
            }
        });
    }

}

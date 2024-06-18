package com.mas.manageIT.views;

import com.mas.manageIT.model.Customer;
import com.mas.manageIT.service.CustomerService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;

import java.util.List;

@PageTitle("Main")
@Menu(icon = "line-awesome/svg/pencil-ruler-solid.svg", order = 0)
@Route(value = "")
@RouteAlias(value = "")
public class MainView extends VerticalLayout {

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

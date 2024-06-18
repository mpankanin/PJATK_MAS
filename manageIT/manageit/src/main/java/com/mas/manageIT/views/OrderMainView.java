package com.mas.manageIT.views;

import com.mas.manageIT.model.Order;
import com.mas.manageIT.service.CustomerService;
import com.mas.manageIT.service.OrderService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Route(value = "orders/customer")
public class OrderViewTmp extends Composite<VerticalLayout> implements HasUrlParameter<String> {

    private OrderService orderService;
    private Grid<Order> gridOrders;


    public OrderViewTmp(OrderService orderService) {
        this.orderService = orderService;
        this.gridOrders = new Grid<>(Order.class);

        FormLayout formLayout = new FormLayout();

        ComboBox comboBox = new ComboBox();
        comboBox.setLabel("Actions");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);

        Button button = new Button();
        button.setText("Accept");
        button.setMaxWidth("50px");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        formLayout.add(comboBox, button);

        getContent().add(gridOrders, formLayout);
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String customerId) {
        if (customerId != null) {
            List<Order> orders = orderService.getAll(Long.parseLong(customerId));
            gridOrders.setItems(orders);
        }
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<String> options = Arrays.asList("Create an order", "Pay an order", "Cancel an order");
        comboBox.setItems(options);
    }

}




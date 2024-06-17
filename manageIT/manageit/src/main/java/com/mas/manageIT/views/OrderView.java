package com.mas.manageIT.views;

import com.mas.manageIT.model.Order;
import com.mas.manageIT.service.OrderService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "orders/customer")
public class OrderView extends VerticalLayout implements HasUrlParameter<String> {

    private OrderService orderService;

    private HorizontalLayout mainLayout;
    private VerticalLayout orderDetailsLayout;
    private Grid<Order> gridOrders;

    private List<Order> orders;

    private TextField textFieldId;
    private TextField textFieldDate;
    private TextField textFieldPrice;
    private TextField textFieldStatus;

    public OrderView(OrderService orderService) {
        this.orderService = orderService;
        this.mainLayout = new HorizontalLayout();
        this.orderDetailsLayout = new VerticalLayout();
        this.gridOrders = new Grid<>(Order.class);

        // Set size full for main layout components
        mainLayout.setSizeFull();
        gridOrders.setSizeFull();
        orderDetailsLayout.setSizeFull();
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String customerId) {
        if (customerId != null) {
            orders = orderService.getAll(Long.parseLong(customerId));
            setOrders(orders);
            setSummary();

            // Set flex grow for gridOrders and orderDetailsLayout
            mainLayout.add(gridOrders, orderDetailsLayout);
            mainLayout.setFlexGrow(2, gridOrders);
            mainLayout.setFlexGrow(1, orderDetailsLayout);

            add(mainLayout);
        }
    }

    private void configureGrid() {
        gridOrders.addColumn(Order::getId).setHeader("Id");
        gridOrders.addItemClickListener(event -> {
            Order order = event.getItem();
            showOrderDetails(order);
        });
    }

    private void setOrders(List<Order> orders) {
        if (orders != null) {
            gridOrders.setItems(orders);
            configureGrid(); // Ensure the grid is configured after setting the items
        }
    }

    private void setSummary() {
        orderDetailsLayout.removeAll();

        FormLayout content = new FormLayout();
        textFieldId = new TextField("Id");
        textFieldId.setReadOnly(true);
        content.add(textFieldId);

        textFieldDate = new TextField("Insertion date");
        textFieldDate.setReadOnly(true);
        content.add(textFieldDate);

        textFieldPrice = new TextField("Price");
        textFieldPrice.setReadOnly(true);
        content.add(textFieldPrice);

        textFieldStatus = new TextField("Status");
        textFieldStatus.setReadOnly(true);
        content.add(textFieldStatus);

        orderDetailsLayout.add(new Text("Order properties"), content);
    }

    private void showOrderDetails(Order order) {
        textFieldId.setValue(order.getId().toString());
        textFieldDate.setValue(order.getInsertionDate().toString());
        textFieldPrice.setValue(order.getPrice().toString());
        textFieldStatus.setValue(order.getPaymentStatus().toString());
    }
}

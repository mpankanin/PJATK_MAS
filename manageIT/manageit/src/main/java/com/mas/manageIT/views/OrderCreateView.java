package com.mas.manageIT.views;

import com.mas.manageIT.model.Customer;
import com.mas.manageIT.model.Order;
import com.mas.manageIT.model.enums.PaymentStatus;
import com.mas.manageIT.service.CustomerService;
import com.mas.manageIT.service.OrderService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@Route("orders/customer/create")
public class OrderCreateView extends VerticalLayout implements HasUrlParameter<String> {

    private final OrderService orderService;
    private final CustomerService customerService;
    private Customer customer;

    private final TextField orderPriceField;
    private final Notification notification;


    public OrderCreateView(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;

        FormLayout formLayout = new FormLayout();

        notification = new Notification();
        notification.setPosition(Notification.Position.MIDDLE);

        orderPriceField = new TextField("Price");

        TextField orderStatusField = new TextField("Payment status");
        orderStatusField.setValue("UNPAID");
        orderStatusField.setReadOnly(true);

        Button saveButton = new Button("Save");
        saveButton.setMaxWidth("50px");
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveButton.addClickListener(event -> saveOrder());

        formLayout.add(orderPriceField, orderStatusField, saveButton);

        add(formLayout);
    }

    private void saveOrder() {
        String priceString = orderPriceField.getValue();
        if (priceString.isEmpty()) {
            Notification.show("Price field must be filled", 2000, Notification.Position.MIDDLE);
        } else {
            double price = Double.parseDouble(priceString);
            long id = orderService.getAll().stream().mapToLong(Order::getId).max().orElse(1);
            Order order = new Order(id+1, LocalDate.now(), price, PaymentStatus.UNPAID);
            order.addLink("OrderCustomer", "CustomerOrder", customer);
            notification.open();
        }
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String customerId) {
        if (customerId != null) {
            customer = customerService.get(Long.parseLong(customerId));
            Button okButton = new Button("OK", event -> {
                notification.close();
                UI.getCurrent().navigate("orders/customer/" + customerId);
            });
            notification.add(new Text("Order has been crated"), okButton);
        }
    }

}

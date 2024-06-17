package com.mas.manageIT.views.mainpage;


import com.mas.manageIT.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("MainPage")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class MainPageView extends Composite<VerticalLayout> {

//    public MainPageView() {
////        Details details = new Details();
////        basicGrid = new Grid(SamplePerson.class);
////        Button buttonPrimary = new Button();
////        getContent().setWidth("100%");
////        getContent().getStyle().set("flex-grow", "1");
////        details.setWidth("100%");
////        setDetailsSampleData(details);
////        basicGrid.setWidth("100%");
////        basicGrid.getStyle().set("flex-grow", "0");
////        setGridSampleData(basicGrid);
////        buttonPrimary.setText("Button");
////        buttonPrimary.setWidth("min-content");
////        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
////        getContent().add(details);
////        getContent().add(basicGrid);
////        getContent().add(buttonPrimary);
//    }
//
//    private void setDetailsSampleData(Details details) {
//        Span name = new Span("Sophia Williams");
//        Span email = new Span("sophia.williams@company.com");
//        Span phone = new Span("(501) 555-9128");
//        VerticalLayout content = new VerticalLayout(name, email, phone);
//        content.setSpacing(false);
//        content.setPadding(false);
//        details.setSummaryText("Contact information");
//        details.setOpened(true);
//        details.setContent(content);
//    }
//
//    private void setGridSampleData(Grid grid) {
//        grid.setItems(query -> samplePersonService.list(
//                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
//                .stream());
//    }
//
//    @Autowired()
//    private SamplePersonService samplePersonService;
}

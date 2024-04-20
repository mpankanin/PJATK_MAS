package multi_inheritance;

import java.time.LocalDate;
import java.util.List;

public class CustomerSupplier extends Customer implements ISupplier {

    private List<String> products;

    public CustomerSupplier(String name, String surname, LocalDate birthDate, List<String> orders, List<String> products) {
        super(name, surname, birthDate, orders);
        this.products = products;
    }

    @Override
    public List<String> getProducts() {
        return products;
    }

    @Override
    public void setProducts(List<String> products) {
        this.products = products;
    }

}

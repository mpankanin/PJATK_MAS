package multi_inheritance;

import dynamic.PersonDynamic;

import java.time.LocalDate;
import java.util.List;

public class Supplier extends PersonMulti {

    private List<String> products;

    public Supplier(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return super.toString() + " Supplier{" +
                "products=" + products +
                '}';
    }

}

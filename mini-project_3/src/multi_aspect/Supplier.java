package multi_aspect;

import dynamic.PersonDynamic;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.util.List;

public class Supplier extends PersonMultiAspect {

    private List<String> products;

    public Supplier(String name, String surname, LocalDate birthDate, @Nullable String maidenName, @Nullable Boolean isPregnant, @Nullable Boolean isArmyMember, List<String> products) {
        super(name, surname, birthDate, maidenName, isPregnant, isArmyMember);
        this.products = products;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return super.toString() + " multi_inheritance.Supplier{" +
                "products=" + products +
                '}';
    }

}

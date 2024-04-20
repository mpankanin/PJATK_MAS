package multi_inheritance;

import java.time.LocalDate;
import java.util.List;

public class Customer extends PersonMulti {

    private List<String> orders;

    public Customer(String name, String surname, LocalDate birthDate, List<String> orders) {
        super(name, surname, birthDate);
        this.orders = orders;
    }

    public List<String> getOrders() {
        return orders;
    }

    public void setOrders(List<String> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return super.toString() + " Customer{" +
                "orders=" + orders +
                '}';
    }

}

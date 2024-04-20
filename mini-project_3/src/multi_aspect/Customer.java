package multi_aspect;

import dynamic.PersonDynamic;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

public class Customer extends PersonMultiAspect {

    private Double discount;

    public Customer(String name, String surname, LocalDate birthDate, @Nullable String maidenName, @Nullable Boolean isPregnant, @Nullable Boolean isArmyMember, Double discount) {
        super(name, surname, birthDate, maidenName, isPregnant, isArmyMember);
        this.discount = discount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return super.toString() + " multi_inheritance.Customer{" +
                "discount=" + discount +
                '}';
    }

}

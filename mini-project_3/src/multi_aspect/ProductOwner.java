package multi_aspect;

import dynamic.PersonDynamic;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

public class ProductOwner extends PersonMultiAspect {

    private String productName;

    public ProductOwner(String name, String surname, LocalDate birthDate, @Nullable String maidenName, @Nullable Boolean isPregnant, @Nullable Boolean isArmyMember, String productName) {
        super(name, surname, birthDate, maidenName, isPregnant, isArmyMember);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return super.toString() + " multi_inheritance.ProductOwner{" +
                "productName='" + productName + '\'' +
                '}';
    }

}

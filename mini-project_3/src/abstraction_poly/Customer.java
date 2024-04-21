package abstraction_poly;

public class Customer extends Person {

    private String company;

    public Customer(String firstName, String lastName, String email, String phoneNumber, String correspondenceAddress, String company) {
        super(firstName, lastName, email, phoneNumber, correspondenceAddress);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }

}

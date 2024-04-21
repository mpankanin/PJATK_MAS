package abstraction_poly;

public abstract class Person {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String correspondenceAddress;

    public Person(String firstName, String lastName, String email, String phoneNumber, String correspondenceAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.correspondenceAddress = correspondenceAddress;
    }

    public abstract String getType();

}

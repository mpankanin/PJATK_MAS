import java.time.LocalDate;

public abstract class Person {

    private String name;

    private String surname;

    private LocalDate birthDate;

    public Person() {
    }

    public Person(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }



}

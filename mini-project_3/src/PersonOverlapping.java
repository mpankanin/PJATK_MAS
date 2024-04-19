import java.time.LocalDate;
import java.util.List;

public class PersonOverlapping extends ObjectPlusPlus{

    private String name;

    private String surname;

    private LocalDate birthDate;

    public PersonOverlapping(String name, String surname, LocalDate birthDate) {
        super();

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public PersonOverlapping(String name, String surname, LocalDate birthDate, List<String> knownProgrammingLanguages) {
        super();

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;

        //changes a person into a developer
        addDeveloper(knownProgrammingLanguages);
    }

    public PersonOverlapping(String name, String surname, LocalDate birthDate, String productName) {
        super();

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;

        //changes a person into a productOwner
        addProductOwner(productName);
    }

    public void addDeveloper(List<String> knownProgrammingLanguages){
        DeveloperOverlapping developerOverlapping = new DeveloperOverlapping(knownProgrammingLanguages);

    }

    public void addProductOwner(String productName){
        ProductOwnerOverlapping productOwner = new ProductOwnerOverlapping(productName);

    }

}

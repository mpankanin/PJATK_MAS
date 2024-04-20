package overlapping;

import exceptions.AssociationException;
import exceptions.DeveloperNotFoundException;
import exceptions.ProductOwnerNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class PersonOverlapping extends ObjectPlusPlus{

    private String name;
    private String surname;
    private LocalDate birthDate;

    private final static String roleNameGeneralization = "generalizationPerson";
    private final static String roleNameDeveloper = "specializationDeveloper";
    private final static String roleNameProductOwner = "specializationProductOwner";

    public PersonOverlapping(String name, String surname, LocalDate birthDate) {
        super();

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    //Creates person as a multi_inheritance.Developer
    public PersonOverlapping(String name, String surname, LocalDate birthDate, List<String> knownProgrammingLanguages) {
        super();

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;

        //changes a person into a developer
        addDeveloper(knownProgrammingLanguages);
    }

    //Creates person as a multi_inheritance.ProductOwner
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

        //adding developer as a link
        this.addLink(roleNameDeveloper, roleNameGeneralization, developerOverlapping);

    }

    public void addProductOwner(String productName){
        ProductOwnerOverlapping productOwner = new ProductOwnerOverlapping(productName);

        //adding productOwner as a link
        this.addLink(roleNameProductOwner, roleNameGeneralization, productOwner);
    }

    public List<String> getKnownProgrammingLanguages () throws DeveloperNotFoundException {
        //get a developer object
        try {
            ObjectPlusPlus[] objects = this.getLinks(roleNameDeveloper);
            return ((DeveloperOverlapping) objects[0]).getKnownProgrammingLanguages();
        }catch (Exception exception) {
            throw new DeveloperNotFoundException("The object is not a multi_inheritance.Developer");
        }
    }

    public String getProductName() throws ProductOwnerNotFoundException {
        try {
            ObjectPlusPlus[] objects = this.getLinks(roleNameProductOwner);
            return ((ProductOwnerOverlapping) objects[0]).getProductName();
        }catch (Exception exception) {
            throw new ProductOwnerNotFoundException("The object is not a multi_inheritance.ProductOwner");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}');
        try {
            if (this.anyLink(roleNameDeveloper)) {
                //multi_inheritance.Developer
                ObjectPlusPlus[] object = this.getLinks(roleNameDeveloper);

                sb.append("multi_inheritance.Developer: " + ((DeveloperOverlapping) object[0]).toString());
            }

            if (this.anyLink(roleNameProductOwner)) {
                //multi_inheritance.ProductOwner
                ObjectPlusPlus[] object = this.getLinks(roleNameProductOwner);

                sb.append("multi_inheritance.ProductOwner: " + (((ProductOwnerOverlapping) object[0]).toString()));
            }

        }catch (Exception exception){
            throw new AssociationException("Error getting links.");
        }

        return sb.toString();
    }

}

package dynamic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FemaleDynamic extends PersonDynamic {

    private String maidenName;
    private boolean isPregnant;

    private static List<FemaleDynamic> extent = new ArrayList<>();

    public FemaleDynamic(String name, String surname, LocalDate birthDate, String maidenName, boolean isPregnant){
        super(name, surname, birthDate);
        this.maidenName = maidenName;
        this.isPregnant = isPregnant;
        addFemale(this);
    }

    public FemaleDynamic(PersonDynamic prevPerson, String maidenName, boolean isPregnant){
        //Copy the old data
        super(prevPerson.getName(), prevPerson.getSurname(), prevPerson.getBirthDate());

        //Save the new data
        this.maidenName = maidenName;
        this.isPregnant = isPregnant;

        //Manage extent
        addFemale(this);
        MaleDynamic.removeMale((MaleDynamic) prevPerson);
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public boolean isPregnant() {
        return isPregnant;
    }

    public void setPregnant(boolean pregnant) {
        isPregnant = pregnant;
    }

    public static void addFemale(FemaleDynamic female){
        extent.add(female);
    }

    public static void removeFemale(FemaleDynamic female){
        extent.remove(female);
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + FemaleDynamic.class.getName());
        for (FemaleDynamic female : extent){
            System.out.println(female);
        }
    }

    public static List<FemaleDynamic> getExtent() {
        return extent;
    }

    @Override
    public String toString() {
        return "Female{" +
                "maidenName='" + maidenName + '\'' +
                ", isPregnant=" + isPregnant +
                '}';
    }

}

package dynamic;

import java.util.ArrayList;
import java.util.List;

public class MaleDynamic extends PersonDynamic {

    private boolean isArmyMember;

    private static List<MaleDynamic> extent = new ArrayList<>();

    public MaleDynamic(PersonDynamic prevPerson, boolean isArmyMember){
        //Copy the old data
        super(prevPerson.getName(), prevPerson.getSurname(), prevPerson.getBirthDate());

        //Save the new data
        this.isArmyMember = isArmyMember;

        //Manage extent
        FemaleDynamic.removeFemale((FemaleDynamic) prevPerson);
        addMale(this);
    }

    public boolean isArmyMember() {
        return isArmyMember;
    }

    public void setArmyMember(boolean armyMember) {
        isArmyMember = armyMember;
    }

    public static void addMale(MaleDynamic male){
        extent.add(male);
    }

    public static void removeMale(MaleDynamic male){
        extent.remove(male);
    }

    public static void showExtent(){
        System.out.println("Extent of the class: " + MaleDynamic.class.getName());
        for (MaleDynamic male : extent){
            System.out.println(male);
        }
    }

    @Override
    public String toString() {
        return "Male{" +
                "isArmyMember=" + isArmyMember +
                '}';
    }

}

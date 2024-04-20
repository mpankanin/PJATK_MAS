package multi_aspect;

import dynamic.PersonDynamic;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.util.List;

public class Developer extends PersonMultiAspect {

    private List<String> knownProgrammingLanguages;

    public Developer(String name, String surname, LocalDate birthDate, @Nullable String maidenName, @Nullable Boolean isPregnant, @Nullable Boolean isArmyMember, List<String> knownProgrammingLanguages) {
        super(name, surname, birthDate, maidenName, isPregnant, isArmyMember);
        this.knownProgrammingLanguages = knownProgrammingLanguages;
    }

    public List<String> getKnownProgrammingLanguages() {
        return knownProgrammingLanguages;
    }

    public void setKnownProgrammingLanguages(List<String> knownProgrammingLanguages) {
        this.knownProgrammingLanguages = knownProgrammingLanguages;
    }

    @Override
    public String toString() {
        return super.toString() + " multi_inheritance.Developer{" +
                "knownProgrammingLanguages=" + knownProgrammingLanguages +
                '}';
    }

}

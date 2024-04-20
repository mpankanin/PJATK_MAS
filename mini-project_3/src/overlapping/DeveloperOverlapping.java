package overlapping;

import java.util.List;

public class DeveloperOverlapping extends ObjectPlusPlus{

    private List<String> knownProgrammingLanguages;

    public DeveloperOverlapping() {
    }

    public DeveloperOverlapping(List<String> knownProgrammingLanguages) {
        this.knownProgrammingLanguages = knownProgrammingLanguages;
    }

    public List<String> getKnownProgrammingLanguages(){
        return knownProgrammingLanguages;
    }

    public void setKnownProgrammingLanguages(List<String> knownProgrammingLanguages) {
        this.knownProgrammingLanguages = knownProgrammingLanguages;
    }

    @Override
    public String toString() {
        return "multi_inheritance.Developer{" +
                "knownProgrammingLanguages=" + knownProgrammingLanguages +
                '}';
    }

}

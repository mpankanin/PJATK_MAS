package multi_aspect;

import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

public abstract class PersonMultiAspect {

    private String name;
    private String surname;
    private LocalDate birthDate;

    //Optional attributes

    //Female
    @Nullable
    private String maidenName;
    @Nullable
    private Boolean isPregnant;

    //Male
    @Nullable
    private Boolean isArmyMember;

    public PersonMultiAspect() {
    }

    public PersonMultiAspect(String name, String surname, LocalDate birthDate,
                             @Nullable String maidenName, @Nullable Boolean isPregnant, @Nullable Boolean isArmyMember) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;

        this.maidenName = maidenName;
        this.isPregnant = isPregnant;
        this.isArmyMember = isArmyMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public @Nullable String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(@Nullable String maidenName) {
        this.maidenName = maidenName;
    }

    public @Nullable Boolean getIsPregnant() {
        return isPregnant;
    }

    public void setIsPregnant(@Nullable Boolean pregnant) {
        isPregnant = pregnant;
    }

    public @Nullable Boolean getIsArmyMember() {
        return isArmyMember;
    }

    public void setIsArmyMember(@Nullable Boolean armyMember) {
        isArmyMember = armyMember;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

}

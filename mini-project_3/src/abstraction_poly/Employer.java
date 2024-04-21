package abstraction_poly;

import java.time.LocalDate;

public class Employer extends Person{


    private String role;

    private LocalDate hireDate;

    private Integer salary;

    public Employer(String firstName, String lastName, String email, String phoneNumber, String correspondenceAddress, String role, LocalDate hireDate, Integer salary) {
        super(firstName, lastName, email, phoneNumber, correspondenceAddress);
        this.role = role;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }

}

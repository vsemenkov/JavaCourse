package homeWork2;

public class EmployeeBuilder {

    public String firstName;

    public EmployeeBuilder setFirstName(String firstName1) {
        this.firstName = firstName1;
        return this;
    }
    public String getFirstName() {
        return this.firstName;
    }
}

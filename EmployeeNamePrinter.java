package homeWork2;

public class EmployeeNamePrinter implements Printer {
    @Override
    public void print(Employee employee) {
        if (employee.firstName.isEmpty() || employee.lastName.isEmpty()) {
            System.out.println("First Name and Last Name cannot be empty");
        } else {
            System.out.println("First Name: " + employee.firstName);
            System.out.println("Last Name: " + employee.lastName);
            System.out.println("Position:" + employee.position);
        }
    }
}
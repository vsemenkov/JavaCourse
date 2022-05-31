package HomeWork2;

public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Vova","Semenkov", 34,"6464",25000);
        EmployeeNamePrinter namePrinter = new EmployeeNamePrinter();
        namePrinter.print(employee1);

        EmployeeSalaryPrinter salaryPrinter = new EmployeeSalaryPrinter();
        salaryPrinter.print(employee1);

        EmployeeTeamPrinter teamPrinter = new EmployeeTeamPrinter();
        teamPrinter.print(employee1);


        Employee employee2 = new Employee("","", 16,"",-25000);
        namePrinter.print(employee2);
        salaryPrinter.print(employee2);
        teamPrinter.print(employee2);

    }
}

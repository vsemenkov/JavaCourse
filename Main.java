package homeWork2;

public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Vova", "Semenkov", 34, "64645", 25000, POSITION.JUNIOR);
        EmployeeNamePrinter namePrinter = new EmployeeNamePrinter();
        namePrinter.print(employee1);

        EmployeeSalaryPrinter salaryPrinter = new EmployeeSalaryPrinter();
        salaryPrinter.print(employee1);

        EmployeeTeamPrinter teamPrinter = new EmployeeTeamPrinter();
        teamPrinter.print(employee1);


        Employee employee2 = new Employee("", "", 16, "", -25000, POSITION.SENIOR);
        namePrinter.print(employee2);
        salaryPrinter.print(employee2);
        teamPrinter.print(employee2);

        Employee employee3 = new Employee("Gleb", "Popov", 25, "AQA", POSITION.SENIOR);
        namePrinter.print(employee3);
        salaryPrinter.print(employee3);

        //ne sozdaem novie peren=mennie a rabotaem s indeksami
        Employee[] employees = new Employee[2];
        employees[0] = new Employee("Sasha", "Petrov", 35, "AQA", POSITION.JUNIOR);
        employees[1] = new Employee("Igor", "Astakhov", 45, "Develop", POSITION.SENIOR);

        //namePrinter.print(employees[0]);
        //salaryPrinter.print(employees[0]);

        //namePrinter.print(employees[1]);
        //salaryPrinter.print(employees[1]);

        //for (int i = 0; i < employees.length; i++) {
           // namePrinter.print(employees[i]);
            //salaryPrinter.print(employees[i]);
        //}


        //Ukorochenaya zapisb
        for (Employee employee : employees) {
            namePrinter.print(employee);
            salaryPrinter.print(employee);
        }
    }
}

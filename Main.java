package homeWork2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Vova", "Semenkov", 34, "64645", 0, POSITION.JUNIOR);
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
        Employee[] employees = new Employee[5];
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
            if (employee != null) {
                namePrinter.print(employee);
                salaryPrinter.print(employee);
            }
        }

        //realizaciya interfeysa listov cherez list massiviv
        List<Employee> employeeList = new ArrayList<>();
        //employeeList.add(new Employee("List", "Massivov", 45, "Develop", POSITION.JUNIOR));
        //employeeList.add(new Employee("List2", "Massivov2", 25, "Develop", POSITION.MIDDLE));
        //employeeList.add(new Employee("List3", "Massivov3", 35, "AQA", POSITION.JUNIOR));
        //employeeList.add(new Employee("List4", "Massivov4", 55, "AQA", POSITION.SENIOR));
        //employeeList.add(new Employee("List4", "Massivov4", 55, "AQA", POSITION.MIDDLE));
        addToList(new Employee("List", "Massivov", 45, "Develop", POSITION.JUNIOR),employeeList);
        addToList(new Employee("List4", "Massivov4", 55, "AQA", POSITION.SENIOR),employeeList);
        addToList(new Employee("List4", "Massivov4", 55, "AQA", POSITION.SENIOR),employeeList);
        addToList(new Employee("List4", "Massivov4", 55, "AQA", POSITION.SENIOR),employeeList);

        for (Employee employee : employeeList){
            namePrinter.print(employee);
            salaryPrinter.print(employee);
        }

        //Sortirivka JUNIOR, MIDDLE, JUNIOR, SENIOR -> JUNIOR, JUNIOR, MIDDLE, SENIOR
        //[JUNIOR,MIDDLE] -> [JUNIOR,MIDDLE]
        //[MIDDLE,JUNIOR] -> [JUNIOR,MIDDLE]

        //for (int i = 0; i < employeeList.size() - 1; i++){
            //if (employeeList.get(i).position.ordinal() > employeeList.get(i+1).position.ordinal()){
                //Collections.swap(employeeList, i, i+1);
            //}
        //}

        System.out.println(employeeList);



        Employee employee4 = new Employee("Vova", "Semenkov", 34, "64645", 25555, POSITION.JUNIOR);
        System.out.println(employee4.getFirstName());
        employee4.setFirstName("New first name");
        System.out.println(employee4.getFirstName());
        System.out.println("======================\n");

        Employee employee5 = new Employee();
        employee5.setTeam("New Team");
        employee5.setAge(48);
        employee5.setPosition(POSITION.SENIOR);

        System.out.println(employee5.getTeam());
        System.out.println(employee5.getAge());
        System.out.println(employee5.getPosition());


        var employee6 = new EmployeeBuilder()
                .setFirstName("SASHA");
        System.out.println(employee6.getFirstName());


        var singleton1 = Singleton.INSTANCE;
        var singleton2 = Singleton.INSTANCE;
        //var singleton1 = Singleton.getInstance();
        //var singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1);


    }

    public static void addToList( Employee employee, List<Employee> employeeList){
        if (!employeeList.contains(employee)) {
            employeeList.add(employee);
        }
        else {
            System.out.println("Duplicated employee " + employee.firstName + " " + employee.lastName);
        }
    }
}

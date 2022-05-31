package homeWork2;

public class EmployeeTeamPrinter implements Printer {

    public String regex = "\\d+";
    @Override
    public void print(Employee employee) {
        if (employee.team == "Glip") {
            System.out.println("Your team is: " + employee.team);
        } else if (employee.team.isEmpty()){
            System.out.println("Incorrect Team name");
        } else if (employee.team.matches(regex)){
            System.out.println("team name include numbers");
        }
    }
}
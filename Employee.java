package homeWork2;



public class Employee {
    public String firstName;
    public String lastName;
    public int age;
    public String team;
    public long salary;

    public Employee(String firstName, String lastName, int age, String team, long salary){ //constructor

        if (age < 18){
            System.out.print("Incorrect age value" + "\n");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.team = team;
        this.salary = salary;
    }

}

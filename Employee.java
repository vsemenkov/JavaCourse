package homeWork2;



public class Employee {
    public String firstName;
    public String lastName;
    public int age;
    public String team;
    public long salary;
    public POSITION position; //employee position

    public Employee() {

    }

    public void setFirstName(String firstName1) {
        this.firstName = firstName1;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setPosition(POSITION position) {
        this.position = position;
    }

    public  String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    public long getSalary() {
        return salary;
    }

    public POSITION getPosition() {
        return position;
    }

    public Employee(String firstName, String lastName, int age, String team, POSITION position){
        this(firstName, lastName, age, team,0, position);
    }
    public Employee(String firstName, String lastName, int age, String team, long salary, POSITION position){ //constructor

        if (age < 18){
            System.out.print("Incorrect age value" + "\n");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.team = team;

        if (salary == 0){
            salary = position.minSalary;

            //switch (position){
                //case JUNIOR : salary = 5000;
                  //  break;
                //case MIDDLE : salary = 10000;
                    //break;
                //case SENIOR: salary = 20000;
                   // break;
                //default: salary = -100000;
            //}

            //if (position == POSITION.JUNIOR){
                //this.salary = 5000;
            //} else if (position == POSITION.MIDDLE){
             //   this.salary = 10000;
           // } else if (position == POSITION.SENIOR){
            //    this.salary = 20000;
            //}
        } else {
            this.salary = salary;
        }
        this.position = position;
    }

    //pereopredelili class toString dlyz vivoda lista
    public String toString(){
        return "Employee info: " + this.firstName + " " + this.lastName + " " + this.position.toString();
    }

    //pereopredelyaem equals
    public  boolean equals(Object obj){
        if (obj instanceof Employee) {
            if ( ((Employee) obj).firstName.equals(this.firstName) &&
                    ((Employee) obj).lastName.equals(this.lastName)){
                return  true;
            }
        }
        return false;
    }

    public void work(){
        for (int i = 0; i < 10; i++){
            System.out.println( firstName + " " + "works: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int compute(){
        int result = 1;
        for (int i = 1; i < 20; i++){
            result = result * i;
        }
        return result;
    }
}

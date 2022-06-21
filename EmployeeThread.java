package homeWork2;

//Ispolzuutsya kokda nugno prosto chto-to sdelatb. Mi obratno nichego ne gdem
public class EmployeeThread extends Thread{

    private Employee employee;

    public EmployeeThread(Employee employee){
        this.employee = employee;
    }

    public void run(){
        employee.work();
    }

    public Employee getEmployee(){
        return  employee;
    }
}

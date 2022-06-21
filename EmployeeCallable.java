package homeWork2;

import java.util.concurrent.Callable;

//Ispolzuetsya kogda nugno zabratb resultat iz potoka
public class EmployeeCallable implements Callable<Integer> {

    private  Employee employee;

    public EmployeeCallable(Employee employee){
        this.employee = employee;
    }

    @Override
    public Integer call() {
        return employee.compute();
    }
}

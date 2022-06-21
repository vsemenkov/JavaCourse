package homeWork2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Runner {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        addToList(new Employee("List", "Massivov", 45, "Develop", POSITION.JUNIOR),employeeList);
        addToList(new Employee("List4", "Massivov4", 55, "AQA", POSITION.MIDDLE),employeeList);
        addToList(new Employee("List5", "Massivov5", 55, "AQA", POSITION.MIDDLE),employeeList);
        addToList(new Employee("List6", "Massivov6", 55, "AQA", POSITION.SENIOR),employeeList);

        //Sozdanie tredov (potoki)
        List<EmployeeThread> threads = new ArrayList<>();
        for (Employee employee : employeeList){
            threads.add(new EmployeeThread(employee));
        }


        //Zapusk tredov
        for (EmployeeThread thread : threads){
            thread.start();
            try {
                //join pozvolyaet zapustitb opredelenniy potok i posle nego uge vse ostalnie
                if (thread.getEmployee().firstName.equals("List") && thread.getEmployee().lastName.equals("Massivov")){
                    thread.join();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        //sozdaly enployeeCallable b=i v kajdiy pologili nashego employee kotoriy budet rabotatb
        List<EmployeeCallable> callables = new ArrayList<>();
        for (Employee employee : employeeList){
            callables.add(new EmployeeCallable(employee));
        }
        //na osnovanii EmployeeCollable sozdaly list future task, pologili future task v potok i zapustili potok
        List<FutureTask<Integer>> futureTasks = new ArrayList<>();
        for (EmployeeCallable callable : callables){
            FutureTask<Integer> futureTask = new FutureTask<>(callable);
            futureTasks.add(futureTask);
            Thread thread = new Thread(futureTask);
            thread.start();
        }
        //begaem po future task i u kagdogo zabiraem get
        for (FutureTask<Integer> futureTask : futureTasks){
            try {
                System.out.println(futureTask.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        //service po obrabotke potokov
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (Employee employee : employeeList){
        service.execute(new Runnable() {
            @Override
            public void run() {
                employee.work();
            }
        });
    }
        service.shutdown();

        ExecutorService callableService = Executors.newFixedThreadPool(2);  //sozdaem pool tredov
        List<Future<Integer>>  futureList = new ArrayList<>();  //list dlya budushih resultatov
        for (Employee employee : employeeList){  //begim po spisku sotrudnikov
            Future<Integer> future = callableService.submit(employee::compute);  //otdaem servisu nashih sotrudnikov, kotorie compute
            futureList.add(future);  //vnosim v list obektu budushih resultatov
        }

        for (Future<Integer> future : futureList){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        callableService.shutdown();
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

package homeWork2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeInfoReader {

    public void read(){
        FileInputStream fileInputStream = null;
        String info = "";
        byte[] date = new byte[0];

        try {
            fileInputStream = new FileInputStream("./info.txt");
            date = new byte[fileInputStream.available()]; //vibiraet dostupnoe kol-vo bayt v faylike
            fileInputStream.read(date);
            info = new String(date);
        } catch ( IOException exception){


        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException exception){
                    System.out.println("Cannot close file");
                    exception.printStackTrace();
                }
            }
        }

        String[] employeeInfos = info.split("\n");
        List<Employee> employeeList = new ArrayList<>();
        Employee employee;
        for (String employeeInfo : employeeInfos){
            String[] employeeDate = employeeInfo.split(" ");
            employee = new Employee(employeeDate[0],employeeDate[1], 34," Default team",POSITION.valueOf(employeeDate[2]));
            employeeList.add(employee);
        }
    }
}

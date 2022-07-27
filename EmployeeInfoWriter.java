package homeWork2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class EmployeeInfoWriter {

    private final Employee employee;

    public EmployeeInfoWriter(Employee employee) {
        this.employee = employee;
    }

    public void write() {
        //Vivod dannih v file
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("./info.txt",true);
            fileOutputStream.write(employee.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException exception) {
            System.out.println("Cannot write to file");
            exception.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException exception) {
                    System.out.println("Cannot close file");
                    exception.printStackTrace();
                }

            }
        }
    }
}
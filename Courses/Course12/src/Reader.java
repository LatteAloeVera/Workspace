import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args) {
        File employeeFile = new File("Employees.txt");
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        try {
            //Ayberk Sevgi 20 Computer Engineering\n
            Scanner scan = new Scanner(employeeFile);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                //TODO: make regex
                String[] splitLine = line.split(", ");

                String name = splitLine[0];
                String surname = splitLine[1];
                int age = Integer.parseInt(splitLine[2]);
                String department = splitLine[3];
                
                employeeList.add(new Employee(name, surname, age, department));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Employee employee : employeeList) {
            employee.showEmployee();
        }

    }
}

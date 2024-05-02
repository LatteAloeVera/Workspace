import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.classfile.Signature.TypeArg.WildcardIndicator;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        // Create an Employee class with some attributes and ask user to enter how many
        // employees he wants to add.
        // Then ask user to enter the details of each employee and store them in an
        // array.
        // Then, write details of each employee in a file.
        // Use Serialization and Deserialization to write and read the file.

        ArrayList<Employee> employeeArray = new ArrayList<Employee>();
        Scanner scanTerminal = new Scanner(System.in);
        boolean legitAnswer = false;
        int employeeAmount = 0;

        while (legitAnswer == false) {
            try {
                System.out.print("How many employees you want to add?: ");
                employeeAmount = scanTerminal.nextInt();
                scanTerminal.nextLine();
                if (employeeAmount < 0) {
                    throw new Exception("Number cannot be below 0");
                }
                legitAnswer = true;
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println();
            }
        }

        System.out.println();
        System.out.println();

        for (int i = 1; i <= employeeAmount; i++) {
            try {
                System.out.println("Enter " + i + ".employee's");
                System.out.print("Name: ");
                String employeeName = scanTerminal.nextLine();

                System.out.print("Surname: ");
                String employeeSurname = scanTerminal.nextLine();

                System.out.print("Age: ");
                int employeeAge = scanTerminal.nextInt();
                scanTerminal.nextLine();

                System.out.print("Department: ");
                String employeeDepartment = scanTerminal.nextLine();

                employeeArray.add(new Employee(employeeName, employeeSurname, employeeAge, employeeDepartment));
                System.out.println("**********************************");

            } catch (InputMismatchException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println();
            }
        }

        File employeeFile = new File("Employees.txt");

        try {
            employeeFile.createNewFile();
            FileWriter writer = new FileWriter(employeeFile);

            for (Employee employee : employeeArray) {
                writer.write(employee.getName() + ", " + employee.getSurname() + ", " + employee.getAge() + ", "
                        + employee.getDepartment() + "\n");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
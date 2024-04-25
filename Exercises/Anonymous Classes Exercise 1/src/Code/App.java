package Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Comparator<Employee> compareByName = new Comparator<Employee>() {
        //     public int compare(Employee a, Employee b) {
        //         int difference = a.getName().charAt(0) - a.getName().charAt(0);

        //         if (difference > 0)
        //             return 1;
        //         if (difference == 0)
        //             return 0;
        //         return -1;
        //     }
        // };

        Comparator<Employee> compareByAge = new Comparator<Employee>() {
            public int compare(Employee a, Employee b) {
                int difference = a.getAge() - b.getAge();

                if(difference > 0)
                    return -1;
                if(difference == 0)
                    return 0;
                return 1;
            }
        };

        Comparator<Employee> compareBySalary = new Comparator<Employee>(){
            public int compare(Employee a, Employee b) {
                Double difference = a.getSalary() - b.getSalary();

                if (difference > 0)
                    return 1;
                if (difference == 0)
                    return 0;
                return -1;
            }
        };

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 30, 80000));
        employees.add(new Employee("Jane Smith", 45, 95000));
        employees.add(new Employee("Alice Johnson", 40, 70000));
        employees.add(new Employee("Bob Brown", 25, 50000));

        Collections.sort(employees, compareByAge);

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("************************************");

        Collections.sort(employees, compareBySalary);

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("************************************");

    }
}

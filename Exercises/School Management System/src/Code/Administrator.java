package Code;

public class Administrator extends StaffMember {
    private String department;

    public Administrator(String name, int age, String position, String department) {
        super(name, age, position);
        this.department = department;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Position: " + position);
        System.out.println("Department: " + department);
    }

}

package Code;

public class SupportStaff extends StaffMember {
    private String shift;

    public SupportStaff(String name, int age, String position, String shift) {
        super(name, age, position);
        this.shift = shift;
    }
    
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Position: " + position);
        System.out.println("Shift: " + shift);
    }
}

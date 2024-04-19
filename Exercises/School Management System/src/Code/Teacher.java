package Code;

public class Teacher extends StaffMember {
    private String subject;

    public Teacher(String name, int age, String position, String subject) {
        super(name, age, position);
        this.subject = subject;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Position: " + position);
        System.out.println("Subject: " + subject);
    }

    


}

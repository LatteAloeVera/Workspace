package Code;

public class StaffMember {
    protected String name;
    protected int age;
    protected String position;

    public StaffMember(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Position: " + position);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    
    
    

}

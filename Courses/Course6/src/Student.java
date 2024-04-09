public class Student {
    public String name, surname;
    public int age;

    Student(){
        this.name = "Unknown!";
        this.surname = "Unknown!";
        this.age = 0;
    }

    Student(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    Student(Student student){
        this.name = student.name;
        this.surname = student.surname;
        this.age = student.age;
    }

    public void eat(){
        System.out.println(this.name + " is eating!");
    }

    public void sleep(){
        System.out.println(this.name + " is sleeping!");
    }

    public void showDetails(){
        System.out.println("Name: " + this.name);
        System.out.println("Surname: " + this.surname);
        System.out.println("Age: " + this.age);
        System.out.println();
    }
}

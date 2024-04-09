/**
 * Person
 */
public class Person {
    // Attributes
    public String name, surname;
    public int age;

    // Constructors
    // 1. Default Constructor
    Person(){
        this.name = "Unknown!";
        this.surname = "Unknown!";
        this.age = 0;
    }

    // 2. Parameterised Constructor
    Person(String name, String surname, int age){
        this.name = name;
        this.age = age;
        this.surname = surname;
    }

    // 3. Copy Constructor
    Person(Person obj){
        this.name = obj.name;
        this.surname = obj.surname;
        this.age = obj.age;
    }

    // Methods
    public void eat(){
        System.out.println(this.name + " is eating!");
    }

    public void sleep(){
        System.out.println(this.name + " is sleeping!");
    }

    public void printDetails(){
        System.out.println("Name: " + this.name);
        System.out.println("Surname: " + this.surname);
        System.out.println("Age: " + this.age);
        System.out.println();
    }
}
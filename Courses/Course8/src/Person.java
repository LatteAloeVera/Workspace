public class Person {
    protected String name;
    protected String surName;
    protected int age;

    Person(String name, String surname, int age){
        this.name = name;
        this.surName = surname;
        this.age = age;
    }

    public void sleep(){
        System.out.println("sleeping...");
        //sleep
    }
    public void walk(){
        System.out.println("walking...");
        //walk
    }

    public void details(){
        System.out.println("Person: " + name + " " + surName + " " + age);
    }
}

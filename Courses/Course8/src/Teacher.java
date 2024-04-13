public class Teacher extends Person {
    private String mastery;

    public void teach(){
        System.out.println("teaching...");
        //teach
    } 

    Teacher(String name, String surName, int age, String mastery){
        super(name,surName,age);
        this.mastery = mastery;
    }

    public void details(){
        System.out.println("Teacher: " + name + " " + surName + " " + age + " " +mastery );
    }
    
}

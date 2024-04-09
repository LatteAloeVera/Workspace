public class App {
    public static void main(String[] args) throws Exception {
        Student student1 = new Student();
        Student student2 = new Student("Ayberk", "Sevgi", 20);
        Student student3 = new Student(student2);

        student1.showDetails();
        student2.showDetails();
        student3.showDetails();
    }
}

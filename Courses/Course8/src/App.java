public class App {
    public static void main(String[] args) throws Exception {
        Teacher teacher = new Teacher("Ayberk", "Sevgi", 20, "computer");
        teacher.teach();
        teacher.sleep();
        System.out.println();
        teacher.details();

    }
}

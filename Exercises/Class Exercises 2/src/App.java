public class App {
    public static void main(String[] args) {
        Novel novel = new Novel("1984", "George Orwell", 1949, 328, "Dystopian", "Winston Smith");
        Textbook textbook = new Textbook("Calculus", "James Stewart", 2015, 1152, "Mathematics", "8th Edition");
        Magazine magazine = new Magazine("National Geographic", "Multiple Authors", 2020, 112, 12, true);

        novel.displayDetails();
        System.out.println();
        textbook.displayDetails();
        System.out.println();
        magazine.displayDetails();
    }
}

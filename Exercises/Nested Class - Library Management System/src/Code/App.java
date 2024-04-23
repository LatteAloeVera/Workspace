package Code;
public class App {
    public static void main(String[] args) throws Exception {
        Library.Book b1 = new Library.Book("The Great Gatsby", 123456);
        Library.Book b2 = new Library.Book("1984", 654321);

        Library.addBook(b1);
        Library.addBook(b2);

        Library.displayBooks();
    }
}

package Code;

import java.util.ArrayList;
import java.util.List;

public class Library {
    protected String name;
    protected static List<Book> books = new ArrayList<Book>();

    public Library(String name) {
        this.name = name;
    }

    public static void addBook(Book book) {
        System.out.println("Adding Book: " + book.title + ", ISBN: " + book.isbn);
        books.add(book);
    }

    public static void displayBooks() {
        
        System.out.println("----------------------------------------------------");
        for (Book book : books) {
            book.displayDetails();
        }
        System.out.println("----------------------------------------------------");
    }

    public static class Book {
        protected String title;
        protected int isbn;

        public Book(String title, int isbn) {
            this.title = title;
            this.isbn = isbn;
        }

        public String getTitle() {
            return title;
        }

        public int getIsbn() {
            return isbn;
        }

        public void displayDetails() {
            System.out.println("Title: " + this.getTitle() + ", ISBN: " + this.getIsbn());
        }

    }
}

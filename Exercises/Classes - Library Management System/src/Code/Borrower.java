package Code;

import java.util.ArrayList;

public class Borrower extends Person {
    private String borrowerId;
    private ArrayList<String> borrowedBooks;

    public Borrower(String name, int age, String borrowerId) {
        super(name, age);
        this.borrowerId = borrowerId;
        this.borrowedBooks = new ArrayList<String>();
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<String> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}

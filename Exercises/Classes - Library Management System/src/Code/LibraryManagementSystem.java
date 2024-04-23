package Code;

import java.util.HashMap;
import java.util.Objects;

public class LibraryManagementSystem {
    HashMap<String, Book> bookMap = new HashMap<String, Book>();
    HashMap<String, Borrower> borrowerMap = new HashMap<String, Borrower>();

    public void addBook(Book book) {
        bookMap.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        if (bookMap.containsKey(isbn)) {
            bookMap.remove(isbn);
            System.out.println("Book removed successfully!");
            System.out.println();
        } else {
            System.out.println("There's no isbn named " + isbn);
        }
    }

    public void addBorrower(Borrower borrower) {
        borrowerMap.put(borrower.getBorrowerId(), borrower);
    }

    public void removeBorrower(String borrowerId) {
        if (borrowerMap.containsKey(borrowerId)) {
            borrowerMap.remove(borrowerId);
            System.out.println("Borrower removed successfully!");
            System.out.println();
        } else {
            System.out.println("There's no borrowerId named " + borrowerId);
        }
    }

    public void checkoutBook(String isbn, String borrowerId) {
        // Checking if the check is valid
        if (bookMap.containsKey(isbn) && borrowerMap.containsKey(borrowerId)) {
            // Checking if the book is already borrowed
            if (!bookMap.get(isbn).isChecked()) {
                // Adding the book to the borrower's list of borrowed books
                borrowerMap.get(borrowerId).getBorrowedBooks().add(isbn);

                // Adding its now checked to the book
                bookMap.get(isbn).setChecked(true);

                System.out.println("Borrowing " + bookMap.get(isbn).getTitle()
                        + " for the " + borrowerMap.get(borrowerId).getName() + " borrower!");
            } else {
                System.out.println("This book is already checked!");
            }
        } else {
            System.out.println("There's something wrong with borrowerID or isbn!");
        }
    }

    public void returnBook(String isbn) {
        if (bookMap.containsKey(isbn)) {
            if (bookMap.get(isbn).isChecked()) {
                // looking for the right borrower
                for (Borrower borrower : borrowerMap.values()) {
                    // checking if this borrower has the book
                    if (borrower.getBorrowedBooks().contains(isbn)) {

                        // removing the book from borrower's list and unchecking it
                        borrower.getBorrowedBooks().remove(isbn);
                        bookMap.get(isbn).setChecked(false);
                        return;
                    }
                }
                System.out.println("Book is stolen or lost, couldn't find borrower!");

            } else {
                System.out.println("Book is already not checked!");
            }
        } else {
            System.out.println("There's no book isbn named " + isbn);
        }
    }

    public void listAllAvaibleBooks() {
        for (Book book : bookMap.values()) {
            // if book is not checked, print it
            if (!book.isChecked()) {
                System.out.printf("%-10s, %-15s, %-20s \n",
                        book.getIsbn(), book.getAuthor(), book.getTitle());
            }
        }
    }

    public void findBookByAuthor(String author) {
        for (Book book : bookMap.values()) {
            // looking for any book with the same 'author'
            if (Objects.equals(book.getAuthor(), author)) {
                System.out.printf("%-10s, %-15s, %-20s \n",
                        book.getIsbn(), book.getAuthor(), book.getTitle());
            }
        }
    }

    public void listBooksBorrowedBy(String borrowerId) {
        System.out.println("This person borrowed " + borrowerMap.get(borrowerId).getBorrowedBooks() + " books");
        System.out.println();
    } 
}

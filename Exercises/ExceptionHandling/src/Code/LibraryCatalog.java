package Code;

import java.util.HashMap;

public class LibraryCatalog {
    HashMap<String, Book> bookMap;

    public LibraryCatalog() {
        this.bookMap = new HashMap<String, Book>();
    }

    public void addBook(Book book) {
        bookMap.put(book.getTitle(), book);
    }

    public void removeBook(Book book) throws InvalidBookOperationException {
        if (bookMap.containsValue(book)) {
            bookMap.remove(book.title);
        } else {
            throw new InvalidBookOperationException("This book doesn't exists in this library!");
        }
    }
    
    public void removeBook(String title) throws InvalidBookOperationException {
        if (bookMap.containsKey(title)) {
            bookMap.remove(title);
        } else {
            throw new InvalidBookOperationException("This titled book doesn't exists in this library!");
        }
    }
    
    public void loanBook(Book book) throws InvalidBookOperationException {
        if (bookMap.containsValue(book)) {
            try {
                if (book instanceof FictionBook) {
                    ((FictionBook) book).loan();
                } else if (book instanceof NonFictionBook) {
                    ((NonFictionBook) book).loan();
                }
            } catch (BookNotAvaibleException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            throw new InvalidBookOperationException("This book doesn't exists in this library!");
        }
    }
    
    public void returnBook(Book book) throws InvalidBookOperationException{
        if (bookMap.containsValue(book)) {
            try {
                if (book instanceof FictionBook) {
                    ((FictionBook) book).returnBook();
                } else if (book instanceof NonFictionBook) {
                    ((NonFictionBook) book).returnBook();
                }
            } catch (InvalidBookOperationException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            throw new InvalidBookOperationException("This book doesn't exists in this library!");
        }
    }

    public void viewAllBooks() {
        int amountOfBooks = bookMap.size();
        System.out.println("*************************************************");
        for (Book book : bookMap.values()) {
            book.showDetails();
            if (amountOfBooks > 0) {
                System.out.println("--------------------------------------------------");
            }
        }
        System.out.println("*************************************************");
    }

    

}

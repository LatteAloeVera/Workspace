package Code;

public class FictionBook extends Book implements Loanable{
    FictionBook(String title, String author) {
        super(title, author);
    }
    

    @Override
    public void loan() throws BookNotAvaibleException {
        if (isAvailable) {
            isAvailable = false;

            System.out.println("Loan was successfull for " + this.title + "!");
        }
        else {
            throw new BookNotAvaibleException("Book is already loaned!");
        }
        
    }

    @Override
    public void returnBook() throws InvalidBookOperationException {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book " + this.title + " succsessfully returned!");
        }
        else {
            throw new InvalidBookOperationException("This book isn't loaned!");
        }

    }
    

}

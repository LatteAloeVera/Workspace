package Code;

public interface Loanable {
    public void loan() throws BookNotAvaibleException;
    public void returnBook() throws InvalidBookOperationException;
}

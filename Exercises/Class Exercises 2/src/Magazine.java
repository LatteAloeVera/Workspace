public class Magazine extends Book {
    protected int issueNumber;
    protected boolean monthly;

    public Magazine(String title, String author, int publicationYear, int numPages, int issueNumber,
            boolean monthly) {
        super(title, author, publicationYear, numPages);
        this.issueNumber = issueNumber;
        this.monthly = monthly;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public boolean getMonthly() {
        return monthly;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    @Override
    public void displayDetails() { 
    System.out.println("--------------------------------------------------- Magazine ------------------------------------------------");
    System.out.printf("%20s, -%15s, -%10s, -%6s, -%15s, -%15s\n", title, author, publicationYear, numPages, issueNumber, monthly);
    System.out.println("-------------------------------------------------------------------------------------------------------------");
        
    }

    
    
}

public class Textbook extends Book {
    protected String subject;
    protected String edition;

    public Textbook(String title, String author, int publicationYear, int numPages, String subject, String edition) {
        super(title, author, publicationYear, numPages);
        this.subject = subject;
        this.edition = edition;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public void displayDetails() {
        System.out.println("--------------------------------------------------- Textbook ------------------------------------------------");
        System.out.printf("%20s, -%15s, -%10s, -%6s, -%15s, -%15s\n", title, author, publicationYear, numPages, subject, edition);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
    }
}

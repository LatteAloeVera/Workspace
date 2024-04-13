public abstract class Book {
    protected String title;
    protected String author;
    protected int publicationYear;
    protected int numPages;

    Book(String title, String author, int publicationYear, int numPages){
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.numPages = numPages;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }

    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }

    public void setPublicationYear(int publicationYear){
        this.publicationYear = publicationYear;
    }
    public int getPublicationYear(){
        return this.publicationYear;
    }

    public void setNumPages(int numPages){
        this.numPages = numPages;
    }
    public int getNumPages(){
        return this.numPages;
    }

    public abstract void displayDetails();
    
}

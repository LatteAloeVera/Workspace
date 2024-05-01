package Code;

public abstract class Book {
    protected String title;
    protected String author;
    protected Boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getAvailability() {
        return isAvailable;
    }

    public void setAvailability(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void showDetails(){
        System.out.printf("-%20s, -%15s, -%6s\n", title, author, isAvailable);
    }
}

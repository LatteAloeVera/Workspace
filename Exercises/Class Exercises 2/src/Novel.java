public class Novel extends Book {
    protected String genre;
    protected String mainCharacter;

    Novel(String title, String author, int publicationYear, int numPages, String genre, String mainCharacter){
        super(title, author, publicationYear, numPages);
        this.genre = genre;
        this.mainCharacter = mainCharacter;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }
    public String getGenre(){
        return this.genre;
    }
    
    public void setMainCharacter(String mainCharacter){
        this.mainCharacter = mainCharacter;
    }
    public String getMainCharacter(){
        return this.mainCharacter;
    }

    public void displayDetails(){
        System.out.println("--------------------------------------------------- Novel ---------------------------------------------------");
        System.out.printf("%20s, -%15s, -%10s, -%6s, -%15s, -%15s\n", title, author, publicationYear, numPages, genre, mainCharacter);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
    }
}

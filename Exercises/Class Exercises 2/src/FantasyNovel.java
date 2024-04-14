public class FantasyNovel extends Novel {
    protected String fantasyType;
    protected int readCount;

    public FantasyNovel(String title, String author, int publicationYear, int numPages, String genre,
            String mainCharacter, String fantasyType, int readCount) {
        super(title, author, publicationYear, numPages, genre, mainCharacter);
        this.fantasyType = fantasyType;
        this.readCount = readCount;
    }

    public String getFantasyType() {
        return fantasyType;
    }

    public void setFantasyType(String fantasyType) {
        this.fantasyType = fantasyType;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public void displayDetails() {
        System.out.println(
                "----------------------------------------------------------- Fantasy Novel -----------------------------------------------------------");
        System.out.printf("%20s, -%15s, -%10s, -%6s, -%15s, -%15s, -%15s, -%8s\n", title, author, publicationYear,
                numPages, genre,
                mainCharacter, fantasyType, readCount);
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------");
    }

}

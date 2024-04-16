public class Pig implements Animal {
    private String species;
    private int age;

    public Pig(String species, int age) {
        this.species = species;
        this.age = age;
    }

    public void animalSound() {
        System.out.println("Oink, oink!");
    }

    public void sleep(int hour) {
        System.out.println("(Sleeping for " + hour + " hours)");
        System.out.println("Zzzz...");
    }

    public void run() {
        System.out.println("*Pig starts to run..*");
    }

    public void eat(String food) {
        System.out.println("Pig is eating " + food + "...");
    }

}

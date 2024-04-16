public class Sheep implements Animal {
    private String species;
    private int age;
    private int woolAmountPerc;

    public Sheep(String species, int age, int woolAmountPerc) {
        this.species = species;
        this.age = age;
        this.woolAmountPerc = woolAmountPerc;
    }

    public Sheep(String species, int age) {
        this.species = species;
        this.age = age;
        this.woolAmountPerc = 0;
    }

    public void animalSound() {
        System.out.println("Baa.. Baaa!");
    }

    public void sleep(int hour) {
        System.out.println("(Sleeping for " + hour + " hours)");
        System.out.println("Zzzz...");
    }

    public void run() {
        System.out.println("*Sheep starts to run..*");
    }

    public void eat(String food) {
        System.out.println("Sheep is eating " + food + "...");
    }

    public void growWool(int percentageAmount) {
        System.out.println("Growing wool...");
        woolAmountPerc += percentageAmount;

        if (woolAmountPerc > 100) {
            System.out.println("Sheep's wool is ready to be cut!");
        }
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        Pig pig1 = new Pig("Landrace", 11);
        Pig pig2 = new Pig("Berkshire", 8);
        Sheep sheep1 = new Sheep("Dorper", 5, 70);
        Sheep sheep2 = new Sheep("Merinos", 7);

        pig1.animalSound();
        sheep1.animalSound();
        sheep2.eat("Grass");
        sheep2.growWool(30);
        sheep1.growWool(40);
        pig2.run();
        pig2.sleep(5);
        sheep1.sleep(3);

    }
}

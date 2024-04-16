public class App {
    public static void main(String[] args) throws Exception {
        Pig pig1 = new Pig("Landrace", 11);
        Pig pig2 = new Pig("Berkshire", 8);
        Sheep sheep = new Sheep("Dorper", 5, 70);
        MerinosSheep mSheep = new MerinosSheep(6, 40, 3.4);

        pig1.animalSound();
        sheep.animalSound();
        mSheep.eat("Grass");
        mSheep.growWool(30);
        sheep.growWool(40);
        pig2.run();
        pig2.sleep(5);
        sheep.sleep(3);
        System.out.println();
        System.out.println();

        sheep.viewDetails();
        System.out.println();
        mSheep.viewDetails();

    }
}

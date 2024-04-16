public class MerinosSheep extends Sheep {
    private double woolThickness;

    public MerinosSheep(int age, int woolAmountPerc, Double woolThickness) {
        super("Merinos", age, woolAmountPerc);
        this.woolThickness = woolThickness;
    }

    //override function
    public void viewDetails() {
        System.out.println("*******************************************************");
        System.out.println("This sheep is " + age + "years old.");
        System.out.println("This sheep's specie is merinos");
        System.out.println("This sheep has %" + woolAmountPerc + " amount of wool.");
        System.out.println("This sheep's wool thickness is " + woolThickness + "cm");
        System.out.println("*******************************************************");
    }

    
}

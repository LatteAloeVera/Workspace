import java.util.HashMap;

public class Stock {
    // wares will be listed in here as "Name(string)" and "Amount(int)"
    HashMap<String, Integer> stockMap;
    protected int totalAmountOfWare;

    public Stock() {
        this.stockMap = new HashMap<String, Integer>();
        this.totalAmountOfWare = 0;
    }

    public void addWare(String name, int amount) {
        // if it exist, update it.
        if (this.stockMap.containsKey(name)) {
            this.stockMap.replace(name, this.stockMap.get(name) + amount);
            this.totalAmountOfWare += amount;

            System.out.println("Successfully added " + amount + " more " + name + ".");
        }
        // if this ware is new create it.
        else {
            this.stockMap.put(name, amount);
            this.totalAmountOfWare += amount;

            System.out.println("Successfully added new ware: " + name + " " + amount + " amount.");
            System.out.println();
        }
    }


}

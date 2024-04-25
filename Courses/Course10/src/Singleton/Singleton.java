package Singleton;

/**
 * Singleton
 */
public class Singleton {

    private static Singleton instance = null;
    public int balance;

    private Singleton() {
        this.balance = 100;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
        
}
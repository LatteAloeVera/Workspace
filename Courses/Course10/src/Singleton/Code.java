package Singleton;

/**
 * Code
 */
public class Code {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton3 = Singleton.getInstance();

        singleton1.balance += 10;
        System.out.println(singleton1.balance); // 110

        singleton2.balance += 20;
        System.out.println(singleton2.balance); // 130

        singleton3.balance += 30;
        System.out.println(singleton3.balance); // 160
    }
    
}
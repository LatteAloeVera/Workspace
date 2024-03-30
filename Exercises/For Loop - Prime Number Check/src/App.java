import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = scan.nextInt();
        int n = 0;
        scan.nextLine();

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                n++;
            }
        }

        if (n == 2) {
            System.out.println("This is a prime number!");
        }
        else {
            System.out.println("This is NOT a prime number!");
        }

        // How to optimise this program?
        // Multidimensional Arrays
    }
}

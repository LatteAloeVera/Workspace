import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int randomNumber = rand.nextInt(100);
        int guess;

        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! Try to guess the number!");

        do {
            System.out.print("What is the number?: ");
            guess = scan.nextInt();
            scan.nextLine();

            if (randomNumber > guess) {
                System.out.println("It's higher!");
                System.out.println();
            }
            else if (randomNumber < guess) {
                System.out.println("It's lower!");
                System.out.println();
            }
            else {
                System.out.println("You Won!! it was" + guess);
            }
        }
        while (randomNumber != guess);
    }
}

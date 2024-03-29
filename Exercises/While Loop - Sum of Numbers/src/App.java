import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int numbCount;
        int sum = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("How many numbers will you enter?: ");
            numbCount = scan.nextInt();
            scan.nextLine();

            if (numbCount < 1)
                System.out.println("Please enter a positive value!");
        } while (numbCount < 1);

        while (numbCount != 0) {
            System.out.println();
            System.out.print("Enter the number(s): ");
            sum += scan.nextInt();
            scan.nextLine();

            numbCount--;
        }
        scan.close();

        System.out.println();
        System.out.println();
        System.out.println("sum of the numbers is " + sum + ".");

    }
}

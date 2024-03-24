import java.text.Normalizer.Form;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Take a number from user and then print out the numbers between 0-N that can
        // be divisible by 3 but not 5

        // Scanner scan = new Scanner(System.in);

        // System.out.print("Enter a number:");
        // int num = scan.nextInt();
        // scan.nextLine();

        // for (int i = 0; i <= num; i++) {
        // if (i % 3 == 0 && i % 5 != 0) {
        // System.out.print(i + " ");
        // }
        // }

        // Let user enter an int and then print the factorial of that number

        // Scanner scan = new Scanner(System.in);
        // System.out.print("Enter a number: ");
        // int num = scan.nextInt();
        // scan.nextLine();

        // int result = 1;

        // for (int i = 1; i <= num; i++) {
        // result *= i;
        // }
        // System.out.println("Result is: " + result);

        // Let user enter 'base' and 'exponent' and then find out base^exponent

        // Scanner scan = new Scanner(System.in);

        // System.out.print("Enter a base: ");
        // int base = scan.nextInt();
        // scan.nextLine();

        // System.out.println();
        // System.out.print("Enter a exponent: ");
        // int exp = scan.nextInt();
        // scan.nextLine();

        // int result = 1;

        // for (int i = 0; i < exp; i++) {
        // result *= base;
        // }

        // System.out.println("Result is: " + result);

        /*
         * 
         * | *
         * | * * *
         * | * * * * *
         * | * * * * * * *
         * |* * * * * * * * *
         * 
         * s(x) = 5 - x
         * A(x) = 2x - 1
         */

        // for (int i = 1; i <= 5; i++) {
        // for (int j = 0; j < 5 - i; j++) {
        // System.out.print(" ");
        // }
        // for (int k = 0; k < (2 * i) - 1; k++) {
        // System.out.print("* ");
        // }
        // System.out.println();
        // }

        /*
         *
         * 
         * *
         * * *
         * * * *
         * * * * *
         * 
         */

        // for (int i = 1; i <= 5; i++) {
        // for(int j = 1; j <= i; j++){
        // System.out.print("* ");
        // }
        // System.out.println();
        // }

        /*
         * 
         * 1
         * 1 2
         * 1 2 3
         * 1 2 3 4
         * 1 2 3 4 5
         * 
         */

        // for (int i = 1; i <= 5; i++) {
        // for (int num = 1; num <= i; num++) {
        // System.out.print(num + " ");
        // }
        // System.out.println();
        // }

        /*
         * A
         * B B
         * C C C
         * D D D D
         * E E E E E
         */

        // int num = 65;

        // for (int i = 1; i <= 5; i++) {
        // for (int j = 0; j < i; j++) {
        // System.out.print((char)num + " ");
        // }
        // num++;
        // System.out.println();
        // }

        /*
         * 
         * 1
         * 2 3 2
         * 3 4 5 4 3
         * 4 5 6 7 6 5 4
         * 5 6 7 8 9 8 7 6 5
         * 
         * numbCount(x) = 2x - 1;
         * 
         * 
         * 
         */

        // for (int i = 1; i <= 5; i++) {
        //     for (int j = 0; j < 5 - i; j++) {
        //         System.out.print("  ");
        //     }
        //     for (int k = i; k <= (2 * i) - 1; k++) {
        //         System.out.print(k + " ");
        //     }
        //     for (int t = (2 * i) - 2; t >= i; t--) {
        //         System.out.print(t + " ");
        //     }

        //     System.out.println();
        // }

        /*
            While, Do-While, Single Dimensional Arrays
        */
    }
}

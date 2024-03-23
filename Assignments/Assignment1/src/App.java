import java.util.Scanner;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * Let user enter 3 numbers and then print out numbers in descending order.
         * Enter num: 9
         * Enter num: -8
         * Enter num: 6
         * 
         * Output: 9 > 6 > -8
         */

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter num: ");
        int num1 = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter num: ");
        int num2 = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter num: ");
        int num3 = scan.nextInt();
        scan.nextLine();

        System.out.println();
        System.out.println();

        int biggestNum = num1; // first we find the biggest number between the numbers..
        int middleNum;
        int smallestNum;

        if (biggestNum < num2) {
            biggestNum = num2;
        }

        if (biggestNum < num3) {
            biggestNum = num3;
        }

        // then we sort the rest
        if (num2 < num3) {
            middleNum = num3;
            smallestNum = num2;
        } else {
            middleNum = num2;
            smallestNum = num3;
        }

        // at the end, we print it.
        System.out.println(biggestNum + " > " + middleNum + " > " + smallestNum);
    }
}

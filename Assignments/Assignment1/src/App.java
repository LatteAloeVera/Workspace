import java.util.Scanner;

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

        
        if (num1 > num2 && num1 > num3) {
            if (num2 > num3) {
                System.out.println(num1 + " > " + num2 + " > " + num3);
            } else {
                System.out.println(num1 + " > " + num3 + " > " + num2);
            }
        }
        else if (num2 > num1 && num2 > num3) {
            if (num1 > num3) {
                System.out.println(num2 + " > " + num1 + " > " + num3);
            } else {
                System.out.println(num2 + " > " + num3 + " > " + num1);
            }
        }
        else {
            if (num1 > num2) {
                System.out.println(num3 + " > " + num1 + " > " + num2);
            }
            else {
                System.out.println(num3 + " > " + num2 + " > " + num1);
            }
        }
    }
}

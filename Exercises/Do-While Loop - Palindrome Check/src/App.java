import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number :");
        int num = scan.nextInt();
        scan.nextLine();

        int revNum = 0;
        int numCopy = num;

        while (numCopy != 0) {
            revNum = (revNum * 10) + (numCopy % 10);
            numCopy /= 10;
        }

        if (revNum == num) {
            System.out.println("This number is a palindrome!");
        }
        else {
            System.out.println("This number is NOT a palindrome!");
        }
    }
}

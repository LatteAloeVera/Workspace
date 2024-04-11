import java.util.Scanner;

public class Question3 {
    /*
     * Given 32-bit signed integer, reverse digits of an integer. Assume that your function returns 0 when the reversed integer overflows.
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        
        int num = scan.nextInt();
        scan.nextLine();
        scan.close();
        System.out.println("Reversed version of the number is: " + reverse(num));
    }

    public static int reverse(int num){
        int reversedNum = 0;

        do
        {
            reversedNum = (reversedNum * 10 )+ (num % 10);
            num /= 10;
        }while(num != 0);

        return reversedNum;
    }
}

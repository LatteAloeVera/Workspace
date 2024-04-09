import java.util.Scanner;

/**
 * Q1
 */
public class Q1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter base number: ");
        int base = scan.nextInt();
        scan.nextLine();
        
        System.out.print("Enter exponent: ");
        int exp = scan.nextInt();
        scan.nextLine();

        System.out.println();
        System.out.println("Answer with recursive version: " + recursivePow(base, exp));
        System.out.println("Answer with iterative version: " + iterativePow(base, exp));
    }

    // Implement both recursive and iterative versions of `pow` function that takes 2 params which is a base and an exponent.

    public static int recursivePow(int base, int exponent){
        if(exponent <= 0)
            return 1;
        return base * recursivePow(base, exponent - 1);
    }


    public static int iterativePow(int base, int exponent){
        int num = 1;
        for (int i = 0; i < exponent; exponent--){
            num *= base;
        }
        return num;
    }


}
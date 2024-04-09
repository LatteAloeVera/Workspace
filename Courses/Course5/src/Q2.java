import java.util.Scanner;

/**
 * Q2
 */
public class Q2 {

    public static void main(String[] args) throws InterruptedException {
        // Scanner scan = new Scanner(System.in);
        // System.out.print("Enter which fibo number u want to see: ");
        // int N = scan.nextInt();
        // scan.nextLine();

        // System.out.println("Answer in recursive function: " + recFibo(N));
        // System.out.println("Answer in iterative function: " + iterFibo(N));

        for (int index = 0; index < 100; index++) {
            System.out.println("fibo " + index + ": " + iterFibo(index));

        }
        
        Thread.sleep(5000);
        
        for (int index = 0; index < 100; index++) {
            System.out.println("fibo " + index + ": " + recFibo(index));
        }
        
    }

    public static long recFibo(long N){
        if(N <= 2){
            return 1;
        }
        return recFibo(N-1) + recFibo(N-2);
    } 

    public static long iterFibo(long N){
        long num1 = 1;
        long num2 = 1; 
        long num3 = 0;
        for (int i = 0; i < N - 2; i++){
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }

        if(N > 2){
            return num3;
        }
        
        return 1;
    }
}
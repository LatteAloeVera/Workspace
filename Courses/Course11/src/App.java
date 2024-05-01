import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws CustomException{
        // Scanner scan = new Scanner(System.in);

        // try {
        // System.out.print("Enter a number: ");
        // int a = scan.nextInt();
        // scan.nextLine();

        // System.out.print("Enter another number: ");
        // int b = scan.nextInt();
        // scan.nextLine();

        // System.out.println("\nThe answer is :" + a / b);
        // } catch (InputMismatchException e) {
        // System.out.println("Error: " + " This input type is not allowed!");
        // } catch (ArithmeticException e) {
        // System.out.println("Error: " + e.getMessage());
        // }
        // finally{
        // scan.close();
        // }

        // try {
        //     System.out.println("The answer is: " + divide(5, 2));
        // } catch (ArithmeticException e) {
        //     System.out.println("Error: " + e.getMessage());
        // }

        throw new CustomException("This is a custom exception");
    }

    // public static int divide(int a, int b) throws ArithmeticException {
    //     return a / b;
    // }
}

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("How many numbers will you use?: ");
        int n = scan.nextInt();
        scan.nextLine();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter a number:");
            array[i] = scan.nextInt();
            scan.nextLine();
        }

        // 1 1 2 3 4
        int copy = array[n-1];
        for (int i = n - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = copy;
        
        System.out.println("The shifted array is:");
        for (int i = 0; i < n; i++) {
            System.out.print( array[i] + " ");
        }
    }
}

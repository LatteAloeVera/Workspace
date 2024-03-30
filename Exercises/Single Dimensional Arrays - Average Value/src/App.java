import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many numbers will you enter?:");
        
        int k = scan.nextInt();
        float sum = 0;
        scan.nextLine();

        int[] nums = new int[k];

        for (int i = 0; i < k; i++) {
            System.out.print("Enter a number: ");
            nums[i] = scan.nextInt();
            scan.nextLine();

            sum += nums[i];
        }

        System.out.println("Average value in this array is \"" + sum / k + "\" !");
    }
}

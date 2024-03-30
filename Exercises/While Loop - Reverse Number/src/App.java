import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = scan.nextInt();
        scan.nextLine();

        int revNum = 0;

        // 0
        // 4321

        while (num != 0) {
            revNum = (revNum * 10) + (num % 10);
            num /= 10;
        }
        
        System.out.println("Reversed num is: " + revNum);
         
    }
}

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int num;
        Scanner scan = new Scanner(System.in);

        /*
         * This code down here makes so it cleans terminal by:
         * 
         *      \033[H: It moves the cursor at the top left corner of the screen or console.
         *      \033[2J: It clears the screen from the cursor to the end of the screen.
         */

        System.out.print("\033[H\033[2J");

        do {
            System.out.print("Please enter a positive number:");

            num = scan.nextInt();
            scan.nextLine();

            if (num <= 0) {
                System.out.println("\n\n************************************");
                System.out.println("*  This is not a positive number!  *");
                System.out.println("************************************\n\n");

                // using this to make our program's output look good by making it wait 1000 ms.
                Thread.sleep(1000);
            }
        } while (num <= 0);
        
        scan.close();
        System.out.println();
        System.out.println();
        System.out.println(num + " is a positive number!");

    }
}

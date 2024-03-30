import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[] array = new int[10];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter a number: ");
            array[i] = scan.nextInt();
            scan.nextLine();
        }
        
        int biggestnum = array[0];

        for (int i = 0; i < 10; i++) {
            if (array[i] > biggestnum) {
                biggestnum = array[i];
            }
        }

        System.out.println("The biggest number is :" + biggestnum);
         
    }
}

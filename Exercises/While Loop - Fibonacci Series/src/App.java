import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int firstTurn = 0;
        int secondTurn = 1;
        int nextTurn;

        Scanner scan = new Scanner(System.in);
        System.out.print("How many numbers of the Fibonacci series you want to see?: ");
        int n = scan.nextInt();
        scan.nextLine();

        if (n > 0)
            System.out.print(firstTurn + " ");
        if (n > 1)
            System.out.print(secondTurn + " ");


        while (n > 0) {
            nextTurn = firstTurn + secondTurn;
            System.out.print(nextTurn + " ") ;
            
            firstTurn = secondTurn;
            secondTurn = nextTurn;

            n--;
        }

        //0 1 1 2 3 5 8
    }
}

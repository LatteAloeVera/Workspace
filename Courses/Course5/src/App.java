import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        // System.out.print("Bir sayı giriniz: ");
        // int input = scan.nextInt();
        // scan.nextLine();

        // System.out.println();
        // System.out.println("sonuç:" + faktoriyel(input));
        
    }


    public static int faktoriyel(int num){
        if(num <= 1)
           return 1;    // base case
        return num * faktoriyel(num-1);     // recursive case
    }
}

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int height;
        int lenght;

        do {
            System.out.print("Enter a height for the rectangle:");
            height = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter a lenght for the rectangle:");
            lenght = scan.nextInt();
            scan.nextLine();
            if (height <= 1 || lenght <= 1) {
                System.out.println();
                System.out.println("Please input a valid number!");
            }

        } while (height <= 1 || lenght <= 1);

        System.out.print("\033[H\033[2J");

        for (int i = 0; i < lenght; i++) {
            System.out.print("* ");
        }
        System.out.println();

        for (int i = 0; i < height - 2; i++) {
            System.out.print("* ");
            for (int j = 0; j < lenght - 2; j++) {
                System.out.print("  ");
            }
            System.out.print("* ");
            System.out.println();
        }

        for (int i = 0; i < lenght; i++) {
            System.out.print("* ");
        }
        System.out.println();

    }
}

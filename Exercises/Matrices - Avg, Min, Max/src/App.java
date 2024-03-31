import java.util.Scanner;

public class App {
    private static final int ROWS = 5;
    private static final int COLS = 5;
    private static final int[][] cinemaHall = new int[ROWS][COLS];    

    public static void main(String[] args) throws Exception {
        System.out.print("\033[H\033[2J");
        Scanner scan =new Scanner(System.in);
        int input = 0;

        do{
            System.out.print("\033[H\033[2J");
            System.out.println("What you want to do today?");
            System.out.println("(1= Display Cinema Hall)");
            System.out.println("(2= Check Seat Availability)");
            System.out.println("(3= Count Available Seats)");
            System.out.println("(4= Find the First Avaible Seat)");
            System.out.println("(5= Reserve a Seat)");
            System.out.println("(6= Cancel a Reservation)");
            System.out.println("(7= EXIT)");
            System.out.print("Select an option :");

            input = scan.nextInt();
            scan.nextLine();

            System.out.print("\033[H\033[2J");
            switch (input){
                case 1 -> {
                    System.out.print("    ");
                    for (int a = 0; a < COLS ; a++){
                        System.out.print((a+1) + "   ");
                    }
                    System.out.println();
                    for (int i = 0; i < ROWS; i++){
                        System.out.print(" " + (char)(i + 97) + " ");
                        for (int j = 0; j < COLS; j++){
                            System.out.print("[" + cinemaHall[i][j] + "] ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("Press anything to return to menu.");
                    scan.nextLine();
                }
                case 2 -> {
                    System.out.println("Which seat would you want to search?: (first input a row number, then col.)");
                    int row = scan.nextInt() - 1;
                    scan.nextLine();
                    int col = scan.nextInt() - 1;
                    scan.nextLine();

                    System.out.print("\033[H\033[2J");
                    if (cinemaHall[row][col] == 0){
                        System.out.println("This seat is available!");
                    }
                    else{
                        System.out.println("This seat is occupied!");
                    }

                    System.out.println("Press enter to return to main menu.");
                    scan.nextLine();
                }
                case 3 -> {
                    int availableSeatCount = 0;
                    for (int i = 0; i < ROWS; i++){
                        for (int j = 0; j < COLS; j++){
                            if(cinemaHall[i][j] == 0){
                                availableSeatCount++;
                            }
                        }
                    }

                    System.out.println("There's " + availableSeatCount + " seats avaliable!");
                    System.out.println("Press enter to return to main menu");
                    scan.nextLine();
                }
                case 4 -> {
                    boolean isSeatFound = false;
                    for (int i = 0; i < ROWS; i++){
                        for (int j = 0; j < COLS; j++){
                            if(cinemaHall[i][j] == 0){
                                System.out.println("In row " + (i + 97) + ", collumn " + j + 1 + " this seat is avaliable!");
                                isSeatFound = true;
                                break;
                            }
                        }
                        if(isSeatFound){
                            break;
                        }
                    }

                    System.out.println("Press enter to return to main menu");
                    scan.nextLine();
                }
                case 5 -> {
                    int col;
                    int row;
                    System.out.println("Which seat would you want to sit in? (first row, then collumn number) :");
                    row = (int)scan.next().charAt(0);
                    scan.nextLine();
                    col = scan.nextInt() - 1;
                    scan.nextLine();

                    System.out.print("\033[H\033[2J");

                    if (cinemaHall[row - 97][col] == 0){
                        cinemaHall[row - 97][col] = 1;
                        System.out.println("Seat Reserved Successfully!");
                    }
                    else{
                        System.out.println("This seat is already reserved! Pick a different one");
                    }
                    
                    System.out.println("Press enter to return to main menu");
                    scan.nextLine();
                }
                case 6 -> {
                    int col;
                    int row;
                    System.out.println("Which reservation would you want to cancel? (first row, then collumn number) :");
                    row = scan.next().charAt(0);
                    scan.nextLine();
                    col = scan.nextInt() - 1;
                    scan.nextLine();

                    System.out.print("\033[H\033[2J");

                    if (cinemaHall[row - 97][col] == 1){
                        cinemaHall[row - 97][col] = 0;
                        System.out.println("Seat reservation cancelled successfully!");
                    }
                    else{
                        System.out.println("This seat is not reserved! Pick a different one");
                    }
                    
                    System.out.println("Press enter to return to main menu");
                    scan.nextLine();
                }
                case 7 -> {
                    System.out.println("Have a nice day!");
                }
                default ->{
                    System.out.println("This is not in the menu. Please enter a number in the menu!");

                    System.out.println("Press enter to return to main menu");
                    scan.nextLine();
                }
            }
        }
        while (input != 7);
    }
}

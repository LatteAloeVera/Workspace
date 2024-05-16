package Code;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        clearTerminal();
        // Bank bank = Bank.getInstance();

        // Customer customer = new Customer("001", "John Doe");
        // customer.openAccount("12345", 1000.00);
        // bank.addCustomer(customer);

        // Transaction deposit = new Transaction("tx100", "12345", 500.00, "Deposit");
        // bank.performTransaction(deposit);

        // Transaction withdraw = new Transaction("tx101", "12345", 200.00, "Withdraw");
        // bank.performTransaction(withdraw);

        // System.out.println("Final Balance: " + customer.getAccount().getBalance());


        boolean inMenu = true;
        do {
            try {
                switch (mainMenu()) {
                    case 1 -> customerOpMenu();
                    case 2 -> accountOpMenu();
                    case 3 -> inMenu = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (inMenu);

    }
    
    public static int mainMenu() throws InterruptedException {
        do {
            System.out.println("------------------ Welcome! ------------------\n");
            System.out.println("1. Customer operations");
            System.out.println("2. Account operations");
            System.out.println("3. Close program\n");
            System.out.println("-----------------------------------------------\n\n");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice > 0 && choice < 4) {
                clearTerminal();
                return choice;
            }
            else {
                clearTerminal();
                System.out.println("Wrong input, please enter a valid choice!");
                Thread.sleep(1500);
                clearTerminal();
            }
            
        } while (true);

    }

    public static void customerOpMenu() throws InterruptedException {
        boolean isOpFinished = false;
        do {
            System.out.println("------------- Customer Operations -------------\n");
            System.out.println("1. Add customer");
            System.out.println("2. Delete customer\n");
            System.out.println("-----------------------------------------------\n\n");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice > 0 && choice < 3) {
                clearTerminal();

                if (choice == 1) {
                    //add customer
                    System.out.print("Please enter a customerID: ");
                    String customerID = scan.nextLine();
                    clearTerminal();

                    System.out.print("Please enter customer's Name: ");
                    String customerName = scan.nextLine();
                    clearTerminal();

                    Bank bank = Bank.getInstance();
                    Customer customer = new Customer(customerID, customerName);
                    bank.addCustomer(customer);
                    Thread.sleep(1500);
                    clearTerminal();
                    isOpFinished = true;
                }
                else {
                    //delete customer
                    System.out.println("******************************************");
                    for (Customer customer : Bank.getInstance().getCustomerList()) {
                        System.out.printf("* %-20s %-18s*\n", customer.getName(), customer.getCustomerID());
                    }
                    System.out.println("******************************************\n");

                    System.out.print("Which customer would you like to delete? (enter customerID): ");
                    String customerID = scan.nextLine();
                    if (Bank.getInstance().getCustomerByID(customerID) != null) {
                        Bank.getInstance().removeCustomer(customerID);
                        System.out.println("Customer removed succsessfully!");
                        Thread.sleep(1000);
                        clearTerminal();
                        isOpFinished = true;
                    }
                    else{
                        System.out.println("Customer remove failed!");
                        Thread.sleep(1000);
                        clearTerminal();
                    }
                }                
            } else {
                clearTerminal();
                System.out.println("Wrong input, please enter a valid choice!");
                Thread.sleep(1500);
                clearTerminal();
            }

        } while (!isOpFinished);

    }
    
    public static void accountOpMenu() throws InterruptedException {
        boolean bool = true;
        do {
            System.out.print("Please enter your CustomerID: ");
            String customerID = scan.nextLine();
            scan.nextLine();
            for (Customer customer : Bank.getInstance().getCustomerList()) {
                if (customer.getCustomerID().equals(customerID)) {
                    bool = false;
                    System.out.println("Accepted CustomerID!");
                }
            }
            if (bool) {
                System.out.println("Couldnt find this customerID! Please enter a valid ID.\n");
            }

        } while (bool);

        do {
            System.out.println("------------- Customer Operations -------------\n");
            System.out.println("1. Add customer");
            System.out.println("2. Delete customer\n");
            System.out.println("-----------------------------------------------\n\n");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice > 0 && choice < 3) {
                clearTerminal();

                // do what operation they want
            } else {
                clearTerminal();
                System.out.println("Wrong input, please enter a valid choice!");
                Thread.sleep(1500);
                clearTerminal();
            }

        } while (true);
    }
    
    public static void clearTerminal() {
        try {
            String operatingSystem = System.getProperty("os.name");

            if (operatingSystem.contains("Windows")) {
                // Clears the terminal on Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Clears the terminal on Unix/Linux/macOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Handle exceptions here if needed
            e.printStackTrace();
        }
    }
}

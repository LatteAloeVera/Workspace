package Code;

import java.util.Scanner;
import java.util.UUID;

import Exceptions.ExistingAccountException;
import Exceptions.NegativeAmountException;
import Exceptions.NotEnoughBalanceException;
import Exceptions.NullAccountException;

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
            } else {
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
            System.out.println("2. Delete customer");
            System.out.println("3. Exit to main menu\n");
            System.out.println("-----------------------------------------------\n\n");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            clearTerminal();

            switch (choice) {
                case 1 -> {
                    // add customer
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
                    isOpFinished = true;
                }
                case 2 -> {
                    if (Bank.getInstance().getCustomerList().size() == 0) {
                        // There's no customer to delete

                        System.out.println("******************************************");
                        System.out.println("*     There's no customer to delete!     *");
                        System.out.println("******************************************");
                        Thread.sleep(1500);
                    } else {
                        // delete customer
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
                            isOpFinished = true;
                        } else {
                            System.out.println("Customer remove failed!");
                            Thread.sleep(1000);
                        }
                    }
                }
                case 3 -> {
                    isOpFinished = true;
                }
                default -> {
                    clearTerminal();
                    System.out.println("Wrong input, please enter a valid choice!");
                    Thread.sleep(1500);
                }
            }
            clearTerminal();

        } while (!isOpFinished);

    }

    public static void accountOpMenu() throws InterruptedException {
        boolean isIDvalid = false;
        boolean isOpFinished = false;
        String thisCustomerID;

        do {
            System.out.print("Please enter your CustomerID: ");
            thisCustomerID = scan.nextLine();
            for (Customer customer : Bank.getInstance().getCustomerList()) {
                if (customer.getCustomerID().equals(thisCustomerID)) {
                    isIDvalid = true;
                    System.out.println("Accepted CustomerID!");
                }
                Thread.sleep(1000);
                clearTerminal();
            }
            if (!isIDvalid) {
                clearTerminal();
                System.out.println("Couldnt find this customerID! Please enter a valid ID.\n");
                Thread.sleep(1500);
                clearTerminal();
            }

        } while (!isIDvalid);

        Customer thisCustomer = Bank.getInstance().getCustomerByID(thisCustomerID);

        do {
            System.out.println("------------- Customer Operations -------------\n");
            System.out.println("1. Open new account");
            System.out.println("2. Close your account");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Exit Customer Operations\n");
            System.out.println("-----------------------------------------------\n\n");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            clearTerminal();

            // do what operation they want
            switch (choice) {
                case 1 -> {
                    // Open a new account
                    try {
                        thisCustomer.openAccount(UUID.randomUUID().toString());
                        System.out.println("Succsessfully opened your account!");
                    } catch (ExistingAccountException e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(1500);
                }
                case 2 -> {
                    // Close account
                    try {
                        thisCustomer.closeAccount();
                        System.out.println("Succsessfully closed your account!");
                    } catch (NullAccountException e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(1500);

                }
                case 3 -> {
                    // Deposit money
                    Account thisCustomerAccount = thisCustomer.getAccount();
                    if (!thisCustomerAccount.equals(null)) {
                        System.out.print("How much would you like to deposit? :");
                        int moneyAmount = scan.nextInt();
                        scan.nextLine();
                        clearTerminal();
                        try {
                            thisCustomerAccount.deposit(moneyAmount);
                            System.out.println("Deposited $" + moneyAmount + " succsessfully!");
                        } catch (NegativeAmountException e) {
                            e.printStackTrace();
                        }
                        Thread.sleep(1500);
                    } else {
                        System.out.println(
                                "You don't have an account to deposit money! Please open a new account first.");
                        Thread.sleep(2500);
                    }
                }
                case 4 -> {
                    // Withdraw money
                    Account thisCustomerAccount = thisCustomer.getAccount();
                    if (!thisCustomerAccount.equals(null)) {
                        System.out.print("How much would you like to withdraw? :");
                        int moneyAmount = scan.nextInt();
                        scan.nextLine();

                        try {
                            thisCustomerAccount.withdraw(moneyAmount);
                            System.out.println("Withdrew $" + moneyAmount + " succsessfully!");
                        } catch (NegativeAmountException | NotEnoughBalanceException e) {
                            e.printStackTrace();
                        }
                        Thread.sleep(1500);

                    } else {
                        System.out.println(
                                "You don't have an account to withdraw money! Please open a new account first.");
                        Thread.sleep(2500);
                    }

                }
                case 5 -> {
                    // Exit
                    System.out.println("Exiting to main menu...");
                    Thread.sleep(500);
                    isOpFinished = true;
                }

                default -> {
                    System.out.println("Wrong input, please enter a valid choice!");
                    Thread.sleep(1500);

                }
            }
            clearTerminal();

        } while (!isOpFinished);
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

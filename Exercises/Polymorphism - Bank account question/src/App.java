public class App {
    public static void main(String[] args) throws Exception {
        // Create instances of SavingsAccount and CheckingAccount
        SavingsAccount savingsAccount = new SavingsAccount("SA001", 1000,"hi124");
        CheckingAccount checkingAccount = new CheckingAccount("CA001", 1150,"Test123");

        // Store both types of objects in an array of type BankAccount
        BankAccount[] accounts = {savingsAccount, checkingAccount};

        // Perform transactions and print account details
        for (BankAccount account : accounts) {

            account.deposit(500,account.usrPassword); // Deposit $500

            account.withdraw(200, account.usrPassword); // Withdraw $200

            account.withdraw(1500, account.usrPassword); // Try to withdraw $1500

            account.withdraw(100, "potato"); // Try to withdraw $100 with wrong password

            account.withdraw(200, account.usrPassword); // withdraw $200 again

            System.out.println("--------------------");
        }
    }
}

public class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected String usrPassword;

    public BankAccount(String accountNumber, double balance, String usrPassword) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.usrPassword = usrPassword;
    }

    public void showBalance(String usrPassword) {
        System.out.println("Current balance is = $" + this.balance);
        System.out.println();
    }

    public void deposit(double amount, String usrPassword) {
        if (usrPassword == this.usrPassword) {
            this.balance += amount;
            System.out.println("$" + amount + " deposited!");

            System.out.println("New balance is = $" + balance);
            System.out.println();
        } else {
            System.out.println("Wrong password!");
            System.out.println();
        }
    }

    public void withdraw(double amount, String usrPassword) {
        if (usrPassword == this.usrPassword && balance >= amount) {
            this.balance -= amount;
            System.out.println("$" + amount + " withdrawn!");

            System.out.println("Remaining balance is = $" + balance);
            System.out.println();
        } else if (usrPassword != this.usrPassword) {
            System.out.println("Wrong password!");
            System.out.println();
        } else {
            System.out.println("Not enough balance to draw $" + amount + "!");
            showBalance(usrPassword);
        }
    }

}

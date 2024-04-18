public class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected String usrPassword;

    public BankAccount(String accountNumber, double balance, String usrPassword) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.usrPassword = usrPassword;
    }
    
    public void deposit(double amount, String usrPassword) {
        if (usrPassword == this.usrPassword) {
            this.balance += amount;
            System.out.println(amount + " deposited!");
        } else {
            System.out.println("Wrong password!");
        }
    }
    
    public void withdraw(double amount, String usrPassword) {
        if (usrPassword == this.usrPassword) {
            this.balance -= amount;
            System.out.println(amount + " withdrawn!");
        } else {
            System.out.println("Wrong password!");
        }
    }

    

}

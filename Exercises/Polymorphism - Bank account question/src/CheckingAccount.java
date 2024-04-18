public class CheckingAccount extends BankAccount {

    CheckingAccount(String accountNumber, double balance, String usrPassword) {
        super(accountNumber, balance, usrPassword);
    }

    //override method
    public void withdraw(double amount, String usrPassword) {
        if (usrPassword == this.usrPassword && balance >= amount) {
            this.balance -= amount;
            System.out.println(amount + " withdrawn!");

            System.out.println("Remaining balance is = $" + balance);
            System.out.println();

        } else if (usrPassword == this.usrPassword && balance + 100 >= amount) {
            System.out.println("Not enough balance, going to negative...");
            this.balance -= amount + 10;
            System.out.println(amount + " withdrawn! $10 penalty added.");

            System.out.println("New balance is = $" + balance);
            System.out.println();
        }
        else if (usrPassword != this.usrPassword) {
            System.out.println("Wrong password!");
            System.out.println();
        } else {
            System.out.println("Not enough balance to draw $" + amount + "!");
            showBalance(usrPassword);
        }
    }

}

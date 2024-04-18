public class SavingsAccount extends BankAccount {
    SavingsAccount(String accountNumber, double balance, String usrPassword) {
        super(accountNumber, balance, usrPassword);
    }

    //override function
    public void deposit(int amount, String usrPassword) {
        if (usrPassword == this.usrPassword) {
            double interest = (this.balance / 100) * 3;
            this.balance += amount + interest ;

            System.out.println(amount + " deposited, " + interest + " interest added!");
        } else {
            System.out.println("Wrong password!");
        }
    }

}
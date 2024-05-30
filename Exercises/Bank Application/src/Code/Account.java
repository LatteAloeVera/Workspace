package Code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import Exceptions.NegativeAmountException;
import Exceptions.NotEnoughBalanceException;

public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount > 0) {
            this.balance += amount;
            saveAccount();
        } else {
            throw new NegativeAmountException("You cannot enter a negative amount of money to deposit!");
        }

    }

    public void withdraw(double amount) throws NegativeAmountException, NotEnoughBalanceException {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
            saveAccount();
        } else if (amount > 0) {
            throw new NotEnoughBalanceException("You do not have enough balance to do this action!");
        } else {
            throw new NegativeAmountException("You cannot enter a negative amount of money to withdraw!");
        }
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void saveAccount() {
        // check if this person is on the txt
        // if it is there, remove it and add again.
        // if not, simply add.

        File file = new File("src\\Accounts\\" + this.accountNumber + ".txt");

        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(this.accountNumber + "," + this.balance);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

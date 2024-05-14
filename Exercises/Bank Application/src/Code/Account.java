package Code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            saveAccount();
        } else {
            System.out.println("Can not deposit negative amount!");
        }

    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
            saveAccount();
        } else if (amount > 0) {
            System.out.println("You do not have enough balance to do this action!");
        } else {
            System.out.println("Can not withdraw negative amount!");
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

package Code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Exceptions.ExistingAccountException;
import Exceptions.NullAccountException;

public class Customer {
    private String customerID;
    private String name;
    private Account account;

    public Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.account = null;
    }

    public void openAccount(String accountNumber) throws ExistingAccountException {
        if (this.account == null) {
            this.account = new Account(accountNumber);
        } else {
            throw new ExistingAccountException("This customer's account already exists!");
        }
    }

    public void closeAccount() throws NullAccountException {
        if (this.account != null) {

            File file = new File("src\\Accounts\\" + this.account.getAccountNumber() + ".txt");
            file.delete();

            this.account = null;
        } else {
            throw new NullAccountException("This customer's account doesn't exist!");
        }
    }

    public void updateCustomerDetails() {
        // check if person exists in file
        // if it exists, delete it and add again.
        // if it doesnt, just add.

        File file = new File("src\\Customers\\" + this.customerID + ".txt");

        try {
            file.createNewFile();
            FileWriter fWriter = new FileWriter(file);
            fWriter.write(this.customerID + "," + this.name + "," + this.account.getAccountNumber());
            fWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getAccountDetails() {
        return this.account.getAccountNumber() + "," + this.account.getBalance();
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

}

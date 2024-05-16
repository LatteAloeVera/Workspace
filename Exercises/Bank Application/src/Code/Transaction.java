package Code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Transaction {
    private String transactionID;
    private String accountNumber;
    private double amount;
    private String transactionType;

    public Transaction(String transactionID, String accountNumber, double amount, String transactionType) {
        this.transactionID = transactionID;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public void execute() {
        if (this.transactionType.toLowerCase().equals("withdraw")) {
            Bank.getInstance().getCustomerByAccountNo(accountNumber).getAccount().withdraw(amount);
            this.saveTransaction();
        } else if (this.transactionType.toLowerCase().equals("deposit")) {
            Bank bank = Bank.getInstance();
            Customer customer = bank.getCustomerByAccountNo(accountNumber);
            customer.getAccount().deposit(amount);
            this.saveTransaction();
        } else {
            System.out.println("Wrong transaction type!");
        }
    }

    public void saveTransaction() {
        File file = new File("src\\Transactions\\" + this.transactionID + ".txt");

        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(
                    this.transactionID + "," + this.accountNumber + "," + this.amount + "," + this.transactionType);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Customer customer = Bank.getInstance().getCustomerByAccountNo(accountNumber);
        customer.getAccount().saveAccount();
        customer.updateCustomerDetails();
    }

}

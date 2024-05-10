package Code;

public class Customer {
    private String customerID;
    private String name;
    private Account account;

    public Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.account = null;
    }

    public void openAccount(String accountNumber, double initialBalance) {
        if (this.account == null && initialBalance >= 0) {
            this.account = new Account(accountNumber, initialBalance);
        } else if (this.account == null) {
            System.out.println("You cannot enter a negative balance for the new account!");
        } else {
            System.out.println("You already have an account! Close that account in order to open a new one.");
        }
    }

    public void closeAccount() {
        if (this.account != null) {
            this.account = null;
            // TODO: Delete from the accounts file as well...
        } else {
            System.out.println("There is no account to delete!");
        }
    }

    public void updateCustomerDetails() {
        // check if person exists in file
        // if it exists, delete it and add again.
        // if it doesnt, just add.

        
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

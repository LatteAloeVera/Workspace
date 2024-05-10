package Code;

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
            Bank.getInstance().getCustomerByID(accountNumber).getAccount().withdraw(amount);
            this.saveTransaction();
        } else if (this.transactionType.toLowerCase().equals("deposit")) {
            Bank.getInstance().getCustomerByID(accountNumber).getAccount().deposit(amount);
            this.saveTransaction();
        } else {
            System.out.println("Wrong transaction type!");
        }
    }

    public void saveTransaction() {
        // TODO: if transaction doesn't exists, add it to the file.
    }

}

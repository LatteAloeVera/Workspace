package Code;

public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();

        Customer customer = new Customer("001", "John Doe");
        customer.openAccount("12345", 1000.00);
        bank.addCustomer(customer);

        Transaction deposit = new Transaction("tx100", "12345", 500.00, "Deposit");
        bank.performTransaction(deposit);

        Transaction withdrawal = new Transaction("tx101", "12345", 200.00, "Withdrawal");
        bank.performTransaction(withdrawal);

        System.out.println("Final Balance: " + customer.getAccount().getBalance());
    }
}

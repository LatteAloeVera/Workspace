package Code;

import java.util.ArrayList;
import java.util.List;

import Exceptions.NegativeAmountException;
import Exceptions.NotEnoughBalanceException;

public class Bank {
    private static Bank instance = null;
    private List<Customer> customerList;

    private Bank() {
        customerList = new ArrayList<Customer>();
    }

    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }

        return instance;
    }

    public void addCustomer(Customer customer) {
        if (!customerList.contains(customer)) {
            customerList.add(customer);
            System.out.println("Added new customer.");
        } else {
            System.out.println("This customer already exists!");
        }
    }

    public void removeCustomer(String customerID) {
        boolean isRemoved = false;
        for (Customer customer : customerList) {
            if (customer.getCustomerID().equals(customerID)) {
                customerList.remove(customer);
                isRemoved = true;
                System.out.println("Removed this customer.");
                return;
            }
        }

        if (!isRemoved) {
            System.out.println("This customer doesn't exists!");
        }
    }

    public Customer getCustomerByID(String CustomerID) {
        for (Customer customer : customerList) {
            if (customer.getCustomerID().equals(CustomerID)) {
                return customer;
            }
        }
        System.out.println("Couldn't find customer by ID!");
        return null;
    }

    public Customer getCustomerByAccountNo(String accountNumber) {
        for (Customer customer : customerList) {
            if (customer.getAccount().getAccountNumber().equals(accountNumber)) {
                return customer;
            }
        }

        System.out.println("Couldn't find customer by account number!");
        return null;
    }

    public void performTransaction(Transaction transaction) {
        try {
            transaction.execute();
        } catch (NegativeAmountException | NotEnoughBalanceException e) {
            e.printStackTrace();
        }
    }

    protected List<Customer> getCustomerList() {
        return customerList;
    }

}

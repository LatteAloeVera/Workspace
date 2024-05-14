package Code;

import java.util.ArrayList;
import java.util.List;

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

    public void performTransaction(Transaction transaction) {
        transaction.execute();
    }

}

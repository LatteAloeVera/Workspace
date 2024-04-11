public class App {
    public static void main(String[] args) {
        // Initialize ContactManager with a limited size to test the full list scenario
        ContactManager manager = new ContactManager(3); // Let's assume the maximum size is 3 for demonstration

        // Adding contacts
        Contact contact1 = new Contact("1", "John", "Doe", "john.doe@example.com", "1234567890");
        Contact contact2 = new Contact("2", "Jane", "Doe", "jane.doe@example.com", "0987654321");
        Contact contact3 = new Contact("3", "Mike", "Smith", "mike.smith@example.com", "1122334455");

        manager.addContact(contact1);
        manager.addContact(contact2);
        manager.addContact(contact3);

        // Attempting to add a fourth contact to test the full list scenario
        Contact contact4 = new Contact("4", "Emily", "Jones", "emily.jones@example.com", "5566778899");
        manager.addContact(contact4);

        // Removing a contact
        manager.removeContact("2");

        // Updating a contact's details
        manager.updateContact("1", "new.john.doe@example.com", "9876543210");

        // Searching for a contact by name
        System.out.println("Search results for 'Mike':");
        Contact[] searchResults = manager.searchContactByName("Mike");
        for (Contact c : searchResults) {
            System.out.println(c.getFullName() + " - " + c.getEmail());
        }

        // Listing all contacts
        System.out.println("All contacts:");
        manager.listAllContacts();

        // Displaying the total number of contacts
        System.out.println("Total contacts: " + manager.getContactCount());

        // Checking if the contact list is full
        System.out.println("Is the contact list full? " + manager.isContactListFull());
    }
}

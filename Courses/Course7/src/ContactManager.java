public class ContactManager {
    private Contact[] contacts;
    private int currentSize;
    private int capasity;
    

    ContactManager(int size){
        this.currentSize = 0;
        this.capasity = size;
        this.contacts = new Contact[capasity];
    }

    public void addContact(Contact contact){
        if(isContactListFull()){
            System.out.println("***********************************************");
            System.out.println("*   Contact cannot be added, capasity full!   *");
            System.out.println("***********************************************");
            return;
        }

        this.contacts[currentSize] = contact;
        currentSize++;
    }

    //  1  2  3  4  5
    public void removeContact(String contactId){
        for(int i = 0; i < currentSize; i++){
            if (contactId == this.contacts[i].getContactId()){
                for(int j = i; j < currentSize - 1; j++){
                    this.contacts[j] = this.contacts[j + 1];
                }
                this.contacts[currentSize - 1] = null;
                currentSize--;

                return;
            }
        }

        System.out.println("Contact could not be found!");
    }

    public Contact[] searchContactByName(String name){
        int matchingCount = 0;
        for(int i = 0; i < currentSize; i++){
            if(contacts[i].getFirstName() == name){
                matchingCount++;
            }
        }
        if(matchingCount == 0)
            return null;

        Contact[] searchedContacts = new Contact[matchingCount];

        for(int i = 0; i < currentSize; i++){
            if(contacts[i].getFirstName() == name){
                searchedContacts[--matchingCount] = contacts[i];
            }
        }

        return searchedContacts;
    }

    public Contact findContactById(String contactId){
        for(int i = 0; i < currentSize; i++){
            if(contacts[i].getContactId() == contactId){
                return contacts[i];
            }
        }
        System.out.println("ID contact not found!");
        return null;
    }

    public void updateContact(String contactId, String newEmail, String newPhoneNumber){
        findContactById(contactId).updateContactDetails(newEmail, newPhoneNumber);
    }

    public void listAllContacts(){
        System.out.println("-----------------------------------------------------");
        System.out.println();
        for(int i = 0; i < currentSize; i++){
            contacts[i].printDetails();
        }
        System.out.println("-----------------------------------------------------");
    }

    public int getContactCount(){
        return currentSize;
    }

    public boolean isContactListFull(){
        if(currentSize == capasity)
            return true;
        
        return false;
    }
}

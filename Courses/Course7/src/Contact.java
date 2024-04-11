public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    
    Contact(String contactId, String firstName, String lastName, String email, String phoneNumber){
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setContactId(String contactId){
        this.contactId = contactId;
    }
    public String getContactId(){
        return this.contactId;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }

    public void updateContactDetails(String email, String phoneNumber){
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public void printDetails(){
        System.out.print(getContactId() + " ");
        System.out.print(getFirstName() + " ");
        System.out.print(getLastName() + " ");
        System.out.print(getEmail() + " ");
        System.out.println(getPhoneNumber() + " ");
        System.out.println();
    }

}

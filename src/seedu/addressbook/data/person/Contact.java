package seedu.addressbook.data.person;

public class Contact {
	
	public String value;
    private boolean isPrivate;
    
    public Contact(String contact, boolean isPrivate){
    	this.value = contact;
    	this.isPrivate = isPrivate;
    }
    
    protected Contact(){}
    
    public String toString() {
        return value;
    }

    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

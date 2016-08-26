package seedu.addressbook.data.person;

public class AddressParser {
	
	public static String[] parse(String address){
		String[] newAddress = address.split(", ");
		return newAddress;
	}
	
}

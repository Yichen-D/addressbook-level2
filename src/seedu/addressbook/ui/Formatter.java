package seedu.addressbook.ui;

import java.util.ArrayList;
import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Formatter {
	
	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";
	
	/** A platform independent line separator. */
    private static final String LS = System.lineSeparator();
    
    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

	/**
	 *  Returns a decorated user input.
	 *  
	 *  @param command
	 *  	user command
	 */
    public static String decorateCommand(String command){
    	
    	return "[Command entered:" + command + "]";
    	
    }
    
    /**
     *  Returns a decorated request for input.
     */
	public static String decoratedRequest(){
		
		return LINE_PREFIX + "Enter command: ";
		
	}
	
	/**
	 *  Returns a decorated message.
	 *  
	 *  @param message
	 */
	public static String decoratedMessage(String message){
		
		return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
		
	}
	
	/**
	 *  Formats a list of persons as a viewable indexed list.
	 */
	public static List<String> formatPersons(List<? extends ReadOnlyPerson> persons){
		
		final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        return formattedPersons;
		
	}
	
	/** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}

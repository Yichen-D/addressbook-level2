package seedu.addressbook.data.person;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	public final String TEST_NAME_1 = "Harry Potter";
	public final String TEST_NAME_2 = "Harry James Potter";
	public final String TEST_NAME_4 = "harry potter";
	public final String TEST_NAME_5 = "Potter, H.";
	
	@Test
	public void sameName() throws IllegalValueException{
		Name test1 = new Name(TEST_NAME_1);
		Name test2 = new Name(TEST_NAME_1);
		assertEquals(true, test1.isSimilar(test2));
	}
}

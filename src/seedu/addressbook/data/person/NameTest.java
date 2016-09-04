package seedu.addressbook.data.person;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	public final String TEST_NAME_1 = "Harry Potter";
	public final String TEST_NAME_2 = "Harry James Potter";
	public final String TEST_NAME_3 = "Harry botter";
	public final String TEST_NAME_4 = "harry potter";
	//This case should not be considered as similar because the first name may not be same,
	//especially for Asian names.
	public final String TEST_NAME_5 = "Potter, H.";
	
	@Test
	public void sameName() throws IllegalValueException{
		Name test1 = new Name(TEST_NAME_1);
		Name test2 = new Name(TEST_NAME_1);
		assertEquals(true, test1.isSimilar(test2));
	}
	
	@Test
	public void ignoreCasesSame() throws IllegalValueException{
		Name test1 = new Name(TEST_NAME_1);
		Name test4 = new Name(TEST_NAME_4);
		assertEquals(true, test1.isSimilar(test4));
	}
	
	@Test
	public void ignoreCasesDifferent() throws IllegalValueException{
		Name test1 = new Name(TEST_NAME_1);
		Name test3 = new Name(TEST_NAME_3);
		assertEquals(false, test1.isSimilar(test3));
	}
	
	@Test
	public void subSetIgnoreCases() throws IllegalValueException{
		Name test4 = new Name(TEST_NAME_2);
		Name test2 = new Name(TEST_NAME_4);
		assertEquals(true, test4.isSimilar(test2));
	}
	
	
}

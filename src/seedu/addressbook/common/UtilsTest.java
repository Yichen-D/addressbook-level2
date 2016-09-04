package seedu.addressbook.common;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class UtilsTest {
	
	public final Object NULL = null;
	public final Object NOT_NULL = "TEST";
	
	
	//Test for isAnyNull
	@Test
	public void emptyInput(){
		assertEquals(false, Utils.isAnyNull());
	}
	@Test
	public void oneNullInput(){
		assertEquals(true, Utils.isAnyNull(NOT_NULL, NULL));
	}
	@Test
	public void noNullInput(){
		assertEquals(false, Utils.isAnyNull(NOT_NULL, NOT_NULL));
	}
	
	//Test for elementsAreUnique
	@Test
	public void emptyCollection(){
		ArrayList test = new ArrayList();
		assertEquals(true, Utils.elementsAreUnique(test));
	}
	@Test
	public void allUnique(){
		ArrayList<Integer> test = new ArrayList<Integer>();
		for(int i = 0; i< 100; i++){
			test.add(i);
		}	
		assertEquals(true, Utils.elementsAreUnique(test));
	}
	@Test
	public void notAllUnique(){
		ArrayList<Integer> test = new ArrayList<Integer>();
		for(int i = 0; i< 100; i++){
			test.add(i%3);
		}	
		assertEquals(false, Utils.elementsAreUnique(test));
	}
}

package seedu.addressbook.parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;

public class NameTest {
	
	private Name name;
	
	@Before
	public void setup(){
		try {
			name = new Name("John Smith");
		} catch (IllegalValueException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Tests for the isSimilar() method for the Name class
	 */
	@Test
	public void isSimilar_nullOther_returnFalse(){
		assertFalse("No name is similar to a null Name", name.isSimilar(null));
	}
	
	@Test
	public void isSimilar_sameNameObject_returnTrue(){
		assertTrue("A name must be similar to itself", name.isSimilar(name));
	}
}

package seedu.addressbook.parser;

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
		assertFalse(name.isSimilar(null));
	}
}

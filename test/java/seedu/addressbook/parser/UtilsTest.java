package seedu.addressbook.parser;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import seedu.addressbook.common.Utils;

public class UtilsTest {

	/*
	 * Tests for isAnyNull() method of Utils class
	 */
	@Test
	public void utilsIsAnyNull_oneArgOneNull_returnsTrue(){
		assertTrue("One null should return true", Utils.isAnyNull((Object) null) );
	}
	
	@Test
	public void utilsIsAnyNull_twoArgsTwoNull_returnsTrue(){
		assertTrue("At least one (two) null should return true", Utils.isAnyNull((Object) null, (Object) null) );
	}
	
	@Test
	public void utilsIsAnyNull_fiveArgsFiveNull_returnsTrue(){
		assertTrue("At least one (five) should return true", Utils.isAnyNull((Object) null, (Object) null, (Object) null, (Object) null, (Object) null) );
	}
	
	@Test
	public void utilsIsAnyNull_oneArgNoNull_returnsFalse(){
		assertFalse("No null should return false", Utils.isAnyNull(new Object()) );
	}
	
	@Test
	public void utilsIsAnyNull_twoArgsNoNull_returnsFalse(){
		assertFalse("No null should return true", Utils.isAnyNull(new Object(), new Object()) );
	}
	
	@Test
	public void utilsIsAnyNull_fiveArgsNoNull_returnsFalse(){
		assertFalse("No null should return true", Utils.isAnyNull(new Object(), new Object(), new Object(), new Object(), new Object()) );
	}
	
	@Test
	public void utilsIsAnyNull_twoArgsOneNullFirst_returnsTrue(){
		assertTrue("At least one null should return true", Utils.isAnyNull((Object) null, new Object()));
	}
	
	@Test
	public void utilsIsAnyNull_twoArgsOneNullSecond_returnsTrue(){
		assertTrue("At least one null should return true", Utils.isAnyNull(new Object(), (Object) null));
	}
	
	/*
	 * Tests for elementsAreUnique() method for Utils class
	 */
	@Test
	public void utilsElementsAreUnique_empty_returnsTrue(){
		assertTrue("An empty collection has all unique elements", Utils.elementsAreUnique(new ArrayList<Object>()));
	}
	
	@Test
	public void utilsElementsAreUnique_oneItem_returnsTrue(){
		ArrayList<Integer> testCollection = new ArrayList<Integer>();
		testCollection.add(1);
		assertTrue("A collection with one item has all unique elements", Utils.elementsAreUnique(testCollection));
	}
	
	@Test
	public void utilsElementsAreUnique_itemOccursTwice_returnsFalse(){
		ArrayList<Integer> testCollection = new ArrayList<Integer>();
		testCollection.add(1);
		testCollection.add(1);
		assertFalse("A collection with at least one duplicate item returns false", Utils.elementsAreUnique(testCollection));
	}
	
	@Test
	public void utilsElementsAreUnique_twoItemsOccurTwice_returnsFalse(){
		ArrayList<Integer> testCollection = new ArrayList<Integer>();
		testCollection.add(1);
		testCollection.add(1);
		testCollection.add(2);
		testCollection.add(2);
		assertFalse("A collection with at least one duplicate item returns false", Utils.elementsAreUnique(testCollection));
	}
	
	@Test
	public void utilsElementsAreUnique_oneItemOccursThrice_returnsFalse(){
		ArrayList<Integer> testCollection = new ArrayList<Integer>();
		testCollection.add(1);
		testCollection.add(1);
		testCollection.add(2);
		testCollection.add(2);
		assertFalse("A collection with at least one duplicate item returns false", Utils.elementsAreUnique(testCollection));
	}
}

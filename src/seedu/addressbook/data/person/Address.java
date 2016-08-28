package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] addressArray = splitAddressIntoArray(address);
        initializeAddressFromArray(addressArray);
    }

    /**
     * Sets up the block, street, unit and postal code for the current Address object given the addressArray as input
     * @param addressArray the addressArray consisting of the block, street, unit and postal code in that order
     */
    private void initializeAddressFromArray(String[] addressArray) {
		String blockString = addressArray[0];
		String streetString = addressArray[1];
		String unitString = addressArray[2];
		String postalCodeString = addressArray[3];
		
		block = new Block(blockString);
		street = new Street(streetString);
		unit = new Unit(unitString);
		postalCode = new PostalCode(postalCodeString);
		
	}

	/**
     * Split the user input address string into a String array, consisting of the block, street, unit and postal code.
     * Pre-condition: The String must have the block, street, unit and postal code all in that order, separated by commas.
     * 
     * @param address the entire address String
     * @return a String[] of length 4 consisting of the block, street, unit, and postal code
     */
    private String[] splitAddressIntoArray(String address) {
		String[] addressArray = address.split(", ");
		return addressArray;
		
	}

	/**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.toString() + ", " + street.toString() + ", " + unit.toString() + ", " + postalCode.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
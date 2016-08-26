package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, unit number, postal code";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = 
    		"Person addresses should be in this format: a/BLOCK, STREET, UNIT, POSTAL_CODE.";
    public static final String ADDRESS_VALIDATION_REGEX = "\\d+, +[\\w\\.]+, #+\\d+-+\\d+, +\\d+";

    public final String value;
    private boolean isPrivate;
    private Block block;
    private Unit unit;
    private Street street;
    private PostalCode postalCode;

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
        String[] newAddress = address.split(", ");
        this.value = address;
        this.block = new Block(newAddress[0],isPrivate);
        this.street = new Street(newAddress[1],isPrivate);
        this.unit = new Unit(newAddress[2],isPrivate);
        this.postalCode = new PostalCode(newAddress[3],isPrivate);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmail(String)}
 */
public class PostalCode {

    public static final String EXAMPLE = "119043";
    public static final String MESSAGE_POSTALCODE_CONSTRAINTS =
            "Postal code should be a 6-digit number.";
    public static final String POSTALCODE_VALIDATION_REGEX = "\\d+";

    public final String value;
    private boolean isPrivate;
    
    /**
     * Validates given email.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public PostalCode(String postalCode, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        postalCode = postalCode.trim();
        if (!isValidPostalCode(postalCode)) {
            throw new IllegalValueException(MESSAGE_POSTALCODE_CONSTRAINTS);
        }
        this.value = postalCode;
    }

    /**
     * Checks if a given string is a valid person email.
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(POSTALCODE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.value.equals(((PostalCode) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
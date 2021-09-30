package seedu.address.model.person;

import seedu.address.commons.util.StringUtil;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's expected salary in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidExpectedSalary(String)}
 */
public class ExpectedSalary {

    public static final String MESSAGE_CONSTRAINTS = "Expected salary should only contain numbers (no decimals), " +
            "should be non-negative, and it should not be blank";

    /*
     * The first character of the salary must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "\\d+";

    public final String value;

    /**
     * Constructs an {@code ExpectedSalary}.
     *
     * @param expectedSalary A valid expected salary.
     */
    public ExpectedSalary(String expectedSalary) {
        requireNonNull(expectedSalary);
        checkArgument(isValidExpectedSalary(expectedSalary), MESSAGE_CONSTRAINTS);

        String leadingZeroesRemoved = StringUtil.removeLeadingZeroes(expectedSalary);
        value = leadingZeroesRemoved.isEmpty() ? "0" : leadingZeroesRemoved;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidExpectedSalary(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExpectedSalary // instanceof handles nulls
                && value.equals(((ExpectedSalary) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}

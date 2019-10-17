package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a Name.
 *
 * @author Tommy May
 * @version 2019
 */
public class Name {

    private String firstName;
    private String middleName;
    private String lastName;

    /**
     * Constructs an object of type Name.
     *
     * @param firstName a String
     * @param middleName a String
     * @param lastName a String
     * @throws IllegalArgumentException an Exception
     */
    public Name(String firstName, String middleName, String lastName) throws IllegalArgumentException {
        if (firstName == null  || firstName.trim().length() == 0 || !isAlpha(firstName)) {
            throw new IllegalArgumentException("invalid name");
        } else {
            this.firstName = formatName(firstName);
        }
        if (middleName == null || middleName.trim().length() == 0 || !isAlpha(middleName)) {
            throw new IllegalArgumentException("invalid name");
        } else {
            this.middleName = formatName(middleName);
        }
        if (lastName == null || lastName.trim().length() == 0 || !isAlpha(lastName)) {
            throw new IllegalArgumentException("invalid name");
        } else {
            this.lastName = formatName(lastName);
        }
    }

    /**
     * Returns the first name.
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the middle name.
     *
     * @return middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Returns the last name.
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the first name if it is a string of only alphabetical characters.
     *
     * @param firstName a String
     */
    public void setFirstName(String firstName) {
        if (firstName != null  && firstName.trim().length() != 0 && isAlpha(firstName)) {
            this.firstName = formatName(firstName);
        }
    }

    /**
     * Sets the middle name if it is a string of only alphabetical characters.
     *
     * @param middleName a String
     */
    public void setMiddleName(String middleName) {
        if (middleName != null  && middleName.trim().length() != 0 && isAlpha(middleName)) {
            this.middleName = formatName(middleName);
        }
    }

    /**
     * Sets the last name if it is a string of only alphabetical characters.
     *
     * @param lastName a String
     */
    public void setLastName(String lastName) {
        if (lastName != null  && lastName.trim().length() != 0 && isAlpha(lastName)) {
            this.lastName = formatName(lastName);
        }
    }

    private boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]*");
    }

    private String formatName(String name) {
        return name.trim().substring(0, 1).toUpperCase() + name.trim().substring(1).toLowerCase();
    }

}
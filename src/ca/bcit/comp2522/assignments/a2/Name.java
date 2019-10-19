package ca.bcit.comp2522.assignments.a2;

import java.util.Objects;

/**
 * Represents a Name.
 *
 * @author Tommy May
 * @author Aiman Ismail
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
     * @return firstName as a String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the middle name.
     *
     * @return middleName as a String
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Returns the last name.
     *
     * @return lastName as a String
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

    /**
     * Returns a boolean after comparing a Regex pattern.
     *
     * @param name a String
     * @return Boolean
     */
    private boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]*");
    }

    /**
     * Return a formatted string.
     *
     * @param name a String
     * @return name a String
     */
    private String formatName(String name) {
        return name.trim().substring(0, 1).toUpperCase() + name.trim().substring(1).toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) &&
                Objects.equals(middleName, name.middleName) &&
                Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
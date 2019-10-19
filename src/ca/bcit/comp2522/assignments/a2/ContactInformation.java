package ca.bcit.comp2522.assignments.a2;

import java.util.Objects;

/**
 * Represents a persons Contact information.
 *
 * @author Tommy May
 * @version 2019
 */
public class ContactInformation {

    private String phoneNumber;
    private String email;
    private String operatingHours;

    /**
     * Constructs an object of type ContactInformation.
     *
     * @param phoneNumber a String
     * @param email a String
     * @param operatingHours a String
     * @throws IllegalArgumentException an Exception
     */
    public ContactInformation(String phoneNumber, String email, String operatingHours)
            throws IllegalArgumentException {
        if (phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid phone number");
        }

        if (email.matches("^(.+)@(.+)$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email");
        }

        if (operatingHours == null || operatingHours.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid operating hours");
        } else {
            this.operatingHours = operatingHours;
        }
    }

    /**
     * Returns the phone number.
     *
     * @return PhoneNumber a String
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the email.
     *
     * @return Email a String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the operating hours.
     *
     * @return operatingHours a String
     */
    public String getOperatingHours() {
        return operatingHours;
    }

    /**
     * Sets phone number if it is 10 digits.
     *
     * @param phoneNumber an int
     */
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;
        }
    }

    /**
     * Sets email if it is formatted correctly.
     *
     * @param email a String
     */
    public void setEmail(String email) {
        if (email.matches("^(.+)@(.+)$")) {
            this.email = email;
        }
    }

    /**
     * Sets operating hours if it is not null or an empty string.
     *
     * @param operatingHours a String
     */
    public void setOperatingHours(String operatingHours) {
        if (operatingHours != null && operatingHours.trim().length() != 0) {
            this.operatingHours = operatingHours;
        }
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", operatingHours='" + operatingHours + '\'' +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInformation that = (ContactInformation) o;
        return Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(email, that.email) &&
                Objects.equals(operatingHours, that.operatingHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, email, operatingHours);
    }
}

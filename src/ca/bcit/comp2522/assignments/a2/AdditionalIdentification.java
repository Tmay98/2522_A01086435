package ca.bcit.comp2522.assignments.a2;

import java.util.Objects;

/**
 * Represents a two-layer identification card called AdditionalIdentification.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class AdditionalIdentification extends IdentificationCard {

    private String secondIDNumber;
    /**
     * Constructs an object of type AdditionalIdentification.
     *
     * @param organizationName      a String
     * @param cardName              a String
     * @param cardLogo              a Boolean
     * @param cardDescription       a String
     * @param newIDNumber           a String
     * @param newSecondIDNumber     a String
     * @param newIssueAndExpiryDate a IssueAndExpiryDate
     * @param newName               a Name
     */
    public AdditionalIdentification(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
                                    String newIDNumber, String newSecondIDNumber, IssueAndExpiryDate newIssueAndExpiryDate, Name newName) {
        super(organizationName, cardName, cardLogo, cardDescription, newIDNumber, newIssueAndExpiryDate, newName);

        if (newSecondIDNumber == null) {
            throw new IllegalArgumentException("A Card's second Identification Number cannot be null.");
        }
        if (!isAlphaNumeric(newSecondIDNumber)) {
            throw new IllegalArgumentException("Card second Identification Number has illegal characters.");
        } else {
            this.secondIDNumber = newSecondIDNumber;
        }
    }

    /**
     * Set the identification number of a card.
     *
     * @param newIdentificationNumber a String
     */
    public void setIdentificationNumber(String newIdentificationNumber){
        if (newIdentificationNumber == null) {
            throw new IllegalArgumentException("A Card's Identification Number cannot be null.");
        }
        if (!isAlphaNumeric(newIdentificationNumber)) {
            throw new IllegalArgumentException("Card Identification Number has illegal characters.");
        } else {
            this.secondIDNumber = newIdentificationNumber;
        }
    }

    /**
     * Return secondIDNumber as a String.
     *
     * @return a String
     */
    public String getIdentificationNumber() {
        return secondIDNumber;
    }

    @Override
    public String toString() {
        return "AdditionalIdentification{" + "\n" +
                "secondIDNumber=" + secondIDNumber + "\n" +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdditionalIdentification that = (AdditionalIdentification) o;
        return Objects.equals(secondIDNumber, that.secondIDNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), secondIDNumber);
    }
}

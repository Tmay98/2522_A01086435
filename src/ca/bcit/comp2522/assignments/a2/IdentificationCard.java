package ca.bcit.comp2522.assignments.a2;


import java.util.Objects;

/**
 * Represents a Identification Card.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class IdentificationCard extends Card {

    private String identificationNumber;
    private IssueAndExpiryDate issueAndExpiryDate;
    private Name ownerName;

    /**
     * Creates an object of type IdentificationCard.
     *
     * @param organizationName a String
     * @param cardName a String
     * @param cardLogo a Boolean
     * @param cardDescription a String
     * @param newIDNumber a String
     * @param newIssueAndExpiryDate a IssueAndExpiryDate
     * @param newName a Name
     */
    public IdentificationCard(String organizationName, String cardName, Boolean cardLogo, String cardDescription, String newIDNumber, IssueAndExpiryDate newIssueAndExpiryDate, Name newName) {
        super(organizationName, cardName, cardLogo, cardDescription);
        if (newIDNumber == null) {
            throw new IllegalArgumentException("A Card's Identification Number cannot be null.");
        }
        if (!isAlphaNumeric(newIDNumber)) {
            throw new IllegalArgumentException("Card Identification Number has illegal characters.");
        } else {
            this.identificationNumber = newIDNumber;
        }
        if (newIssueAndExpiryDate == null) {
            throw new IllegalArgumentException(("Issue and expiry date is null"));
        } else {
            this.issueAndExpiryDate = newIssueAndExpiryDate;
        }
        if (newName == null) {
            throw new IllegalArgumentException("Card Owner Name is Null");
        } else {
            this.ownerName = newName;
        }
    }

    /**
     * Set the identification number of a card.
     *
     * @param newIdentificationNumber a String
     */
    public void setIdentificationNumber(String newIdentificationNumber){
        if(newIdentificationNumber==null) {
            throw new IllegalArgumentException("A Card's Identification Number cannot be null.");
        }
        if (!isAlphaNumeric(newIdentificationNumber)) {
            throw new IllegalArgumentException("Card Identification Number has illegal characters.");
        } else {
            this.identificationNumber = newIdentificationNumber;
        }
    }

    /**
     * Set the new effective dates a card can be used.
     *
     * @param newDates a IssueAndExpiryDate
     */
    public void setIssueAndExpiryDate(IssueAndExpiryDate newDates){
        if (newDates == null) {
            throw new IllegalArgumentException("Your value is not valid for Issue and Expiry Date");
        } else {
            this.issueAndExpiryDate = newDates;
        }
    }

    /**
     * Set the owner name of the card.
     *
     * @param ownerName a Name
     */
    public void setOwnerName(Name ownerName) {
        if (ownerName == null) {
            throw new IllegalArgumentException("Your value for ownerName is invalid.");
        } else {
            this.ownerName = ownerName;
        }
    }

    /**
     * Return identificationNumber as a String.
     *
     * @return a String
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Return issueAndExpiryDate as a IssueAndExpiryDate.
     *
     * @return a IssueAndExpiryDate
     */
    public IssueAndExpiryDate getIssueAndExpiryDate() {
        return issueAndExpiryDate;
    }

    /**
     * Returns owner name as a Name object.
     *
     * @return a ownerName as a Name
     */
    public Name getOwnerName() {
        return ownerName;
    }

    /**
     * Returns a boolean after verifying a Regex pattern.
     *
     * @param idString as a boolean
     * @return boolean
     */
    public boolean isAlphaNumeric(String idString) {
            return idString.matches("[a-zA-Z0-9_\\-]*");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificationCard that = (IdentificationCard) o;
        return identificationNumber.equals(that.identificationNumber) &&
                issueAndExpiryDate.equals(that.issueAndExpiryDate) &&
                ownerName.equals(that.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificationNumber, issueAndExpiryDate, ownerName);
    }

    @Override
    public String toString() {
        return "IdentificationCard{" +
                "identificationNumber='" + identificationNumber + '\'' +
                ", issueAndExpiryDate=" + issueAndExpiryDate +
                ", ownerName=" + ownerName +
                '}';
    }
}
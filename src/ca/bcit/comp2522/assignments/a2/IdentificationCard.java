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
    public IdentificationCard(String organizationName, String cardName, Boolean cardLogo, String cardDescription,String newIDNumber, IssueAndExpiryDate newIssueAndExpiryDate, Name newName) {
        super(organizationName, cardName, cardLogo, cardDescription);
        this.identificationNumber = newIDNumber;
        this.issueAndExpiryDate = newIssueAndExpiryDate;
        this.ownerName = newName;

    }

    /**
     *
     * @param newIdentificationNumber a String
     */
    public void setIdentificationNumber(String newIdentificationNumber){
        this.identificationNumber = newIdentificationNumber;
    }

    /**
     *
     * @param newDates a IssueAndExpiryDate
     */
    public void setIssueAndExpiryDate(IssueAndExpiryDate newDates){
        this.issueAndExpiryDate = newDates;
    }

    /**
     *
     * @param ownerName a Name
     */
    public void setOwnerName(Name ownerName) {
        this.ownerName = ownerName;
    }

    /**
     *
     * @return a String
     */
    public Object getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     *
     * @return a IssueAndExpiryDate
     */
    public IssueAndExpiryDate getIssueAndExpiryDate() {
        return issueAndExpiryDate;
    }

    /**
     *
     * @return a Name
     */
    public Name getOwnerName() {
        return ownerName;
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
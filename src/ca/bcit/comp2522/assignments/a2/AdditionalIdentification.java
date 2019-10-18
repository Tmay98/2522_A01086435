package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a two-layer identification card called AdditionalIdentification.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class AdditionalIdentification extends IdentificationCard {

    /**
     * Constructs an object of type AdditionalIdentification.
     *
     * @param organizationName      a String
     * @param cardName              a String
     * @param cardLogo              a Boolean
     * @param cardDescription       a String
     * @param newIDNumber           a String
     * @param newIssueAndExpiryDate a IssueAndExpiryDate
     * @param newName               a Name
     */
    public AdditionalIdentification(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
                                    String newIDNumber, IssueAndExpiryDate newIssueAndExpiryDate, Name newName) {
        super(organizationName, cardName, cardLogo, cardDescription, newIDNumber, newIssueAndExpiryDate, newName);
    }
}

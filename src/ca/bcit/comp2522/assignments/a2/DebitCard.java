package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a Debit Card.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class DebitCard extends Financial{
    /**
     * Constructs an object of type Card.
     *
     * @param organizationName a String
     * @param cardName         a String
     * @param cardLogo         a Boolean
     * @param cardDescription  a String
     */
    public DebitCard(String organizationName, String cardName, Boolean cardLogo, String cardDescription) {
        super(organizationName, cardName, cardLogo, cardDescription);
    }
}

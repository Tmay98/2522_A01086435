package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a Financial type of card.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class FinancialCard extends Card {
    /**
     * Constructs an object of type FinancialCard.
     *
     * @param organizationName a String
     * @param cardName         a String
     * @param cardLogo         a Boolean
     * @param cardDescription  a String
     */
    public FinancialCard(String organizationName, String cardName, Boolean cardLogo, String cardDescription) {
        super(organizationName, cardName, cardLogo, cardDescription);
    }
}

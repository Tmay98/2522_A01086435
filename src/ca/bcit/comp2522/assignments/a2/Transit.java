package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a Transit card.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class Transit extends Card{
    /**
     * Constructs an object of type Card.
     *
     * @param organizationName a String
     * @param cardName         a String
     * @param cardLogo         a Boolean
     * @param cardDescription  a String
     */
    public Transit(String organizationName, String cardName, Boolean cardLogo, String cardDescription) {
        super(organizationName, cardName, cardLogo, cardDescription);
    }
}

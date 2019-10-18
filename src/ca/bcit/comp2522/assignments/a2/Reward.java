package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a Reward card.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class Reward extends Card{
    /**
     * Constructs an object of type Card.
     *
     * @param organizationName a String
     * @param cardName         a String
     * @param cardLogo         a Boolean
     * @param cardDescription  a String
     */
    public Reward(String organizationName, String cardName, Boolean cardLogo, String cardDescription) {
        super(organizationName, cardName, cardLogo, cardDescription);
    }
}

package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a Card.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class Card {

    private String organizationName;
    private String cardName;
    private String cardDescription;
    private Boolean cardLogo;

    /**
     * Constructs an object of type Card.
     *
     * @param organizationName a String
     * @param cardName a String
     * @param cardLogo a Boolean
     * @param cardDescription a String
     */
    public Card(String organizationName, String cardName, Boolean cardLogo, String cardDescription) {
        this.organizationName = organizationName;
        this.cardName = cardName;
        this.cardLogo = cardLogo;
        this.cardDescription = cardDescription;
    }

    /**
     * Returns the organization name.
     *
     * @return organizationName
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Returns the card name.
     *
     * @return cardName
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Returns the card description.
     *
     * @return cardDescription
     */
    public String getCardDescription() {
        return cardDescription;
    }

    /**
     * Returns if there is a card logo.
     *
     * @return cardLogo
     */
    public Boolean getCardLogo() {
        return cardLogo;
    }
}

package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a Card.
 *
 * @author Tommy May
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

    public String getOrganizationName() {
        return organizationName;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public Boolean getCardLogo() {
        return cardLogo;
    }
}

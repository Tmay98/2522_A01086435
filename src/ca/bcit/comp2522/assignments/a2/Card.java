package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a Card.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public abstract class Card {

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
        if (organizationName == null  || organizationName.trim().length() == 0 || !isAlpha(organizationName)) {
            throw new IllegalArgumentException("Invalid organization name");
        } else {
            this.organizationName = formatName(organizationName);
        }
        if (cardName == null  || cardName.trim().length() == 0 || !isAlpha(cardName)) {
            throw new IllegalArgumentException("Invalid card name");
        } else {
            this.cardName = formatName(cardName);
        }
        if (cardLogo == null) {
            throw new IllegalArgumentException("Invalid card logo value");
        } else {
            this.cardLogo = cardLogo;
        }
        if (cardDescription == null || cardDescription.trim().length() == 0) {
            throw new IllegalArgumentException("You have an invalid card description.");
        } else {
            this.cardDescription = cardDescription;
        }
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

    private String formatName(String name) {
        return name.trim().substring(0, 1).toUpperCase() + name.trim().substring(1).toLowerCase();
    }

    private boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]*");
    }
}

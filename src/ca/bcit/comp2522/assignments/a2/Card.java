package ca.bcit.comp2522.assignments.a2;

import java.util.Objects;

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
        if (organizationName == null  || organizationName.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid organization name");
        } else {
            this.organizationName = formatName(organizationName);
        }
        if (cardName == null  || cardName.trim().length() == 0) {
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

    public String formatName(String name) {
        return name.trim().substring(0, 1).toUpperCase() + name.trim().substring(1).toLowerCase();
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]*");
    }

    @Override
    public String toString() {
        return "Card{" +
                "organizationName='" + organizationName + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardDescription='" + cardDescription + '\'' +
                ", cardLogo=" + cardLogo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(organizationName, card.organizationName) &&
                Objects.equals(cardName, card.cardName) &&
                Objects.equals(cardDescription, card.cardDescription) &&
                Objects.equals(cardLogo, card.cardLogo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationName, cardName, cardDescription, cardLogo);
    }
}

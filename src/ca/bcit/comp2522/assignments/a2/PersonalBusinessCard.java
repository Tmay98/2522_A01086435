package ca.bcit.comp2522.assignments.a2;

import java.util.Objects;

/**
 * Represents a Personal Business Card.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class PersonalBusinessCard extends BusinessCard {

    private ContactInformation personalContactInformation;

    /**
     * Constructs an object of type PersonalBusinessCard.
     *
     * @param organizationName a String
     * @param cardName a String
     * @param cardLogo a Boolean
     * @param cardDescription a String
     * @param contactInformation a ContactInformation object
     * @param personalContactInformation a ContactInformation object
     * @param address a String
     */
    public PersonalBusinessCard(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
                                ContactInformation contactInformation, ContactInformation personalContactInformation,
                                String address) {
        super(organizationName, cardName, cardLogo, cardDescription, contactInformation, address);

        if (personalContactInformation == null) {
            throw new IllegalArgumentException("Invalid personal contact info");
        } else {
            this.personalContactInformation = personalContactInformation;
        }
    }

    /**
     * Returns the personal contact information.
     *
     * @return PersonalContactInformation
     */
    public ContactInformation getOwnerContactInformation() {
        return personalContactInformation;
    }

    @Override
    public String toString() {
        return "PersonalBusinessCard{" +
                "personalContactInformation=" + personalContactInformation +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalBusinessCard that = (PersonalBusinessCard) o;
        return Objects.equals(personalContactInformation, that.personalContactInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalContactInformation);
    }
}

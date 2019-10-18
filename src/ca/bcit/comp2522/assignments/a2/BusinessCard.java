package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a Business Card.
 *
 * @author Tommy
 * @version 2019
 */
public class BusinessCard extends Card {

    private ContactInformation contactInformation;
    private String address;

    /**
     * Constructs an object of type Business.
     *
     * @param contactInformation ContactInformation
     * @param address a String
     */
    public BusinessCard(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
                        ContactInformation contactInformation, String address) {
        super(organizationName, cardName, cardLogo, cardDescription);
        if (contactInformation == null) {
            throw new IllegalArgumentException("Invalid contact info");
        }

        if (address == null || address.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid operating hours");
        }

        this.contactInformation = contactInformation;
        this.address = address;
    }

    /**
     * Returns the contact information.
     *
     * @return ContactInformation
     */
    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    /**
     * Returns the address.
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address if it isnt null or an empty string.
     *
     * @param address a string
     */
    public void setAddress(String address) {
        if (!(address == null || address.trim().length() == 0)) {
            this.address = address;
        }
    }
}

package ca.bcit.comp2522.assignments.a2;

/**
 * Represents a MembershipCard.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class MembershipCard extends Card {

    private String membershipLevel;

    /**
     * Constructs an object of type MembershipCard.
     *
     * @param organizationName a String
     * @param cardName a String
     * @param cardLogo a Boolean
     * @param cardDescription a String
     * @param membershipLevel a String
     */
    public MembershipCard(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
                          String membershipLevel) {
        super(organizationName, cardName, cardLogo, cardDescription);

        if (membershipLevel == null  || membershipLevel.trim().length() == 0) {
            throw new IllegalArgumentException("invalid name");
        } else {
            this.membershipLevel = formatName(membershipLevel);
        }
    }

    /**
     * Returns the membership level.
     *
     * @return membershipLevel
     */
    public String getMembershipLevel() {
        return membershipLevel;
    }

    /**
     * Sets membership level if it is not null and not an empty string.
     *
     * @param membershipLevel a String
     */
    public void setMembershipLevel(String membershipLevel) {
        if (!(membershipLevel == null  || membershipLevel.trim().length() == 0)) {
            this.membershipLevel = formatName(membershipLevel);
        }
    }
}

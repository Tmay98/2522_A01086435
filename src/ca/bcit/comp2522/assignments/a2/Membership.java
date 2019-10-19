package ca.bcit.comp2522.assignments.a2;

import java.util.Objects;

/**
 * Represents a MembershipCard.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class Membership extends Card {

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
    public Membership(String organizationName, String cardName, Boolean cardLogo, String cardDescription,
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

    @Override
    public String toString() {
        return "MembershipCard{" + "\n" +
                "membershipLevel=" + membershipLevel + "\n" +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return Objects.equals(membershipLevel, that.membershipLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(membershipLevel);
    }
}

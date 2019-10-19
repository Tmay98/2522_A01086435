package ca.bcit.comp2522.assignments.a2;

import java.util.Objects;

/**
 * Represents a PointsRewardCard.
 *
 * @author Tommy May
 * @author Aiman Ismail
 * @version 2019
 */
public class PointsReward extends Identification implements PaymentMethod {

    private int points;
    private Name ownerName;
    /**
     * Constructs an object of type RewardCard.
     *
     * @param organizationName a String
     * @param cardName         a String
     * @param cardLogo         a Boolean
     * @param cardDescription  a String
     * @param newIDNumber a String
     * @param newIssueAndExpiryDate a IssueAndExpiryDate
     * @param newName a Name
     * @param points an int
     */
    public PointsReward(String organizationName, String cardName, Boolean cardLogo,
                        String cardDescription, String newIDNumber, IssueAndExpiryDate newIssueAndExpiryDate,
                        Name newName, int points) {
        super(organizationName, cardName, cardLogo, cardDescription, newIDNumber, newIssueAndExpiryDate, newName);

        if (points < 0) {
            throw new IllegalArgumentException("Points must be a non-negative integer");
        }
        this.points = points;
    }

    /**
     * Returns points amount.
     *
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Sets the amount of points if it is a non-negative integer.
     *
     * @param points an int
     */
    public void setPoints(int points) {
        if (points >= 0) {
            this.points = points;
        }
    }

    /**
     * Pays an amount of points and subtracts it from points.
     *
     * @param amount an int
     */
    @Override
    public void payment(int amount) {
        if (amount < points) {
            points -= amount;
            System.out.println("You payed" + amount + " points");
        } else {
            System.out.println("You dont have enough points!");
        }
    }

    @Override
    public String toString() {
        return "PointsRewardCard{" + "\n" +
                "points=" + points + "\n" +
                "ownerName=" + ownerName + "\n" +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PointsReward that = (PointsReward) o;
        return points == that.points &&
                Objects.equals(ownerName, that.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), points, ownerName);
    }
}
